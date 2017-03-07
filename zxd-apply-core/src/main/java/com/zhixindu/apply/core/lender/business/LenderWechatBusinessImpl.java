package com.zhixindu.apply.core.lender.business;

import com.google.common.collect.Lists;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.service.LenderService;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileBO;
import com.zhixindu.apply.facade.lender.bo.VerifyInfoBO;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;
import com.zhixindu.apply.facade.lender.enums.BankCardVerify;
import com.zhixindu.apply.facade.lender.enums.MobileVerify;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.utils.Parameters;
import com.zhixindu.commons.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("lenderWechatBusiness")
public class LenderWechatBusinessImpl implements DubboApplyLenderWechatBusiness {

    @Inject
    private LenderMapper lenderMapper;
    @Inject
    private LenderAddressMapper lenderAddressMapper;
    @Inject
    private LenderContactMapper lenderContactMapper;
    @Inject
    private LenderBankCardMapper lenderBankCardMapper;
    @Inject
    private LenderService lenderService;

    @Override
    public boolean checkCreditSituation(String customerId) {
        Parameters.requireNotNull(customerId, "customerId不能为空");
        String creditSituation = lenderMapper.selectCreditSituation(customerId);
        if(StringUtils.isBlank(creditSituation)) {
            return true;
        }
        // TODO 解析信用结果
        return false;
    }

    @Override
    public LenderInfoBO applyLoan(LenderBaseInfoBO lenderBaseInfoBO) {
        Parameters.requireAllPropertyNotNull(lenderBaseInfoBO);
        LenderInfoBO lenderInfoBO = new LenderInfoBO();
        LenderBO lenderBO = lenderMapper.selectByCustomerId(lenderBaseInfoBO.getCustomer_id());
        if(null == lenderBO) {
            lenderBO = new LenderBO();
            BeanUtils.copyProperties(lenderBaseInfoBO, lenderBO);
            lenderService.saveLenderBaseInfo(lenderBO);
        }
        BeanUtils.copyProperties(lenderBO, lenderInfoBO);
        AddressBO addressBO = lenderAddressMapper.selectByLenderId(lenderInfoBO.getLender_id());
        if(null != addressBO) {
            lenderInfoBO.setAddressBO(addressBO);
        }
        wrap(lenderInfoBO);
        return lenderInfoBO;
    }

    /**
     * 对关键信息最掩码
     * @param lenderInfo
     */
    private void wrap(LenderInfoBO lenderInfo){
        lenderInfo.setMobile(StringUtil.maskMobile(lenderInfo.getMobile()));
        lenderInfo.setId_card(StringUtil.maskIdNo(lenderInfo.getId_card()));
    }

    @Override
    public List<ContactBO> findLenderContact(int lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        List<ContactBO> contactBOList = lenderContactMapper.selectByLenderId(lenderId);
        if(CollectionUtils.isEmpty(contactBOList)){
            return Lists.newArrayListWithCapacity(0);
        }
        return contactBOList;
    }

    @Override
    public VerifyInfoBO findLenderVerify(int lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        LenderBO lenderBO = lenderMapper.selectByPrimaryKey(lenderId);
        if(null == lenderBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的借款人信息");
        }
        VerifyInfoBO verifyInfoBO = new VerifyInfoBO();
        verifyInfoBO.setLender_id(lenderId);
        verifyInfoBO.setMobile_verify(MobileVerify.VERIFIED.matches(lenderBO.getMobile_verify()));
        verifyInfoBO.setBank_card_verify(BankCardVerify.VERIFIED.matches(lenderBO.getBank_card_verify()));
        return verifyInfoBO;
    }

    @Override
    public BankCardBO findBankCard(int lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        BankCardBO bankCardBO = lenderBankCardMapper.selectByLenderId(lenderId);
        if(null == bankCardBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的银行卡信息");
        }
        bankCardBO.setBank_card_number(StringUtil.maskBankCard(bankCardBO.getBank_card_number()));
        return bankCardBO;
    }

    @Override
    public MobileBO findMobileInfo(int lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        LenderBO lenderBO = lenderMapper.selectByPrimaryKey(lenderId);
        if(null == lenderBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的借款人信息");
        }
        MobileBO mobileBO = new MobileBO();
        mobileBO.setLender_id(lenderId);
        mobileBO.setMobile(StringUtil.maskMobile(lenderBO.getMobile()));
        mobileBO.setService_password(StringUtil.maskPassword(lenderBO.getService_password()));
        return mobileBO;
    }

    @Override
    public boolean submitLenderAddress(AddressBO addressBO) {
        Parameters.requireAllPropertyNotNull(addressBO, new Object[]{"lender_id"});
        return lenderService.saveOrUpdateAddress(addressBO) > 0;
    }

    @Override
    public boolean submitLenderContact(List<ContactBO> contactBOList) {
        if(CollectionUtils.isEmpty(contactBOList)) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "联系人参数不能为空");
        }
        return lenderService.saveOrUpdateContact(contactBOList) > 1;
    }

    @Override
    public boolean submitLenderBankCard(BankCardBO bankCardBO) {
        Parameters.requireAllPropertyNotNull(bankCardBO, new Object[]{"lender_id"});
        return lenderService.saveOrUpdateBankCard(bankCardBO) > 0;
    }

    @Override
    public boolean submitMobile(MobileBO mobileBO) {
        Parameters.requireAllPropertyNotNull(mobileBO);
        return lenderService.saveMobileVerify(mobileBO) > 0;
    }

    @Override
    public boolean submitCreditSituation(Integer lenderId, String creditSituation) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        Parameters.requireNotNull(creditSituation, "creditSituation不能为空");
        return lenderService.saveCreditSituation(lenderId, creditSituation) > 0;
    }

    @Override
    public String findBankCardNumber(Integer lenderId) {
        return lenderBankCardMapper.selectBankCardNumber(lenderId);
    }

}
