package com.zhixindu.apply.core.lender.business;

import com.google.common.collect.Lists;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.service.LenderService;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.utils.Parameters;
import com.zhixindu.commons.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
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
    public  LenderBO findLender(String customerId) {
        Parameters.requireNotNull(customerId, "customerId不能为空");
        return lenderMapper.selectByCustomerId(customerId);
    }

    @Override
    public LenderInfoBO applyLoan(LenderBaseInfoBO lenderBaseInfoBO) {
        Parameters.requireAllPropertyNotNull(lenderBaseInfoBO, new Object[]{"lender_id"});
        if(!lenderService.isExistLender(lenderBaseInfoBO.getCustomer_id())) {
            lenderService.saveLenderBaseInfo(lenderBaseInfoBO);
        }
        LenderInfoBO lenderInfoBO = new LenderInfoBO();
        BeanUtils.copyProperties(lenderInfoBO, lenderInfoBO);
        LenderAddressBO lenderAddressBO = lenderAddressMapper.selectByLenderId(lenderInfoBO.getLender_id());
        if(null != lenderAddressBO) {
            lenderInfoBO.setLenderAddressBO(lenderAddressBO);
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
    public List<LenderContactBO> findLenderContact(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        List<LenderContactBO> lenderContactBOList = lenderContactMapper.selectByLenderId(lenderId);
        if(CollectionUtils.isEmpty(lenderContactBOList)){
            return Lists.newArrayListWithCapacity(0);
        }
        return lenderContactBOList;
    }

    @Override
    public LenderVerifyBO findLenderVerify(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        LenderBO lenderBO = lenderMapper.selectByPrimaryKey(lenderId);
        if(null == lenderBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的借款人信息");
        }
        LenderVerifyBO lenderVerifyBO = new LenderVerifyBO();
        BeanUtils.copyProperties(lenderBO, lenderVerifyBO);
        return lenderVerifyBO;
    }

    @Override
    public LenderBankCardBO findLenderBankCard(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        LenderBankCardBO lenderBankCardBO = lenderBankCardMapper.selectByLenderId(lenderId);
        if(null == lenderBankCardBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的银行卡信息");
        }
        lenderBankCardBO.setBank_card_number(StringUtil.maskBankCard(lenderBankCardBO.getBank_card_number()));
        return lenderBankCardBO;
    }

    @Override
    public LenderMobileVerifyBO findLenderMobileVerify(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        LenderBO lenderBO = lenderMapper.selectByPrimaryKey(lenderId);
        if(null == lenderBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的借款人信息");
        }
        LenderMobileVerifyBO lenderMobileVerifyBO = new LenderMobileVerifyBO();
        lenderMobileVerifyBO.setLender_id(lenderId);
        lenderMobileVerifyBO.setMobile(StringUtil.maskMobile(lenderBO.getMobile()));
        lenderMobileVerifyBO.setService_password(StringUtil.maskPassword(lenderBO.getService_password()));
        return lenderMobileVerifyBO;
    }

    @Override
    public Integer submitLenderAddress(LenderAddressBO lenderAddressBO) {
        Parameters.requireAllPropertyNotNull(lenderAddressBO, new Object[]{"lender_id"});
        return lenderService.saveOrUpdateAddress(lenderAddressBO);
    }

    @Override
    public List<Integer> submitLenderContact(List<LenderContactBO> lenderContactBOList) {
        if(CollectionUtils.isEmpty(lenderContactBOList)) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "联系人参数不能为空");
        }
        return lenderService.saveOrUpdateContact(lenderContactBOList);
    }

    @Override
    public Integer submitLenderBankCard(LenderBankCardBO lenderBankCardBO) {
        Parameters.requireAllPropertyNotNull(lenderBankCardBO, new Object[]{"lender_id"});
        return lenderService.saveOrUpdateBankCard(lenderBankCardBO);
    }

    @Override
    public boolean submitLenderMobileVerify(LenderMobileVerifyBO lenderMobileVerifyBO) {
        Parameters.requireAllPropertyNotNull(lenderMobileVerifyBO);
        return lenderService.saveMobileVerify(lenderMobileVerifyBO) > 0;
    }

    @Override
    public boolean submitApplyResult(ApplyResultBO applyResultBO) {
        Parameters.requireAllPropertyNotNull(applyResultBO);
        return lenderService.saveApplyResult(applyResultBO) > 0;
    }

    @Override
    public String findBankCardNumber(Integer lenderId) {
        return lenderBankCardMapper.selectBankCardNumber(lenderId);
    }

}
