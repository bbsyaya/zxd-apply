package com.zhixindu.apply.core.lender.business;

import com.google.common.collect.Lists;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.service.LenderService;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderVerifyBO;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;
import com.zhixindu.apply.facade.lender.enums.LoanFillStep;
import com.zhixindu.apply.facade.lender.enums.WorkState;
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
    public  LenderBO findLender(String customerId) {
        Parameters.requireNotNull(customerId, "customerId不能为空");
        return lenderMapper.selectByCustomerId(customerId);
    }

    @Override
    public LenderInfoBO applyLoan(LenderBaseInfoBO lenderBaseInfoBO) {
        if(StringUtils.isBlank(lenderBaseInfoBO.getCustomer_id())) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "customerId不能为空");
        }
        if(!lenderService.isExistLender(lenderBaseInfoBO.getCustomer_id())) {
            Parameters.requireAllPropertyNotNull(lenderBaseInfoBO, new Object[]{"lender_id"});
            lenderService.saveLenderBaseInfo(lenderBaseInfoBO);
        } else {
            Parameters.requireAllPropertyNotNull(lenderBaseInfoBO);
        }
        LenderInfoBO lenderInfoBO = new LenderInfoBO();
        BeanUtils.copyProperties(lenderBaseInfoBO, lenderInfoBO);
        lenderInfoBO.setLoan_fill_step(LoanFillStep.BASIC_INFO.getValue());
        lenderInfoBO.setId_card(StringUtil.maskIdNo(lenderInfoBO.getId_card()));
        LenderAddressBO lenderAddressBO = lenderAddressMapper.selectByLenderId(lenderInfoBO.getLender_id());
        if(null != lenderAddressBO) {
            lenderInfoBO.setLenderAddressBO(lenderAddressBO);
        }
        return lenderInfoBO;
    }

    @Override
    public LenderAddressBO findLenderAddress(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        return lenderAddressMapper.selectByLenderId(lenderId);
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
        if(null == lenderAddressBO.getLender_id()) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "lenderId不能为空");
        }
        Object[] ignoreProperties = new Object[]{};
        if(lenderService.isExistLenderAddress(lenderAddressBO.getLender_id())) {
            if(!WorkState.EMPLOYEE.matches(lenderAddressBO.getWork_state())) {
                ignoreProperties = new Object[]{"company_name", "company_address_code", "company_address"};
            }
        } else {
            if(!WorkState.EMPLOYEE.matches(lenderAddressBO.getWork_state())) {
                ignoreProperties = new Object[]{"address_id", "company_name", "company_address_code", "company_address"};
            } else {
                ignoreProperties = new Object[]{"address_id"};
            }
        }
        Parameters.requireAllPropertyNotNull(lenderAddressBO, ignoreProperties);
        return lenderService.saveOrUpdateAddress(lenderAddressBO);
    }

    @Override
    public List<Integer> submitLenderContact(List<LenderContactBO> lenderContactBOList) {
        if(CollectionUtils.isEmpty(lenderContactBOList)) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "联系人参数不能为空");
        }
        lenderContactBOList.forEach(lenderContactBO -> {
            if (null == lenderContactBO.getLender_id()) {
                throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "lenderId不能为空");
            }
            Object[] ignoreProperties = new Object[]{};
            if (!lenderService.isExistLenderBankCard(lenderContactBO.getLender_id())) {
                ignoreProperties = new Object[]{"contact_id"};
            }
            Parameters.requireAllPropertyNotNull(lenderContactBO, ignoreProperties);
        });
        return lenderService.saveOrUpdateContact(lenderContactBOList);
    }

    @Override
    public Integer submitLenderBankCard(LenderBankCardBO lenderBankCardBO) {
        if(null == lenderBankCardBO.getLender_id()) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "lenderId不能为空");
        }
        Object[] ignoreProperties = new Object[]{};
        if(!lenderService.isExistLenderBankCard(lenderBankCardBO.getLender_id())) {
            ignoreProperties = new Object[]{"bank_card_id"};
        }
        Parameters.requireAllPropertyNotNull(lenderBankCardBO, ignoreProperties);
        return lenderService.saveOrUpdateBankCard(lenderBankCardBO);
    }

    @Override
    public boolean submitLenderMobileVerify(LenderMobileVerifyBO lenderMobileVerifyBO) {
        Parameters.requireAllPropertyNotNull(lenderMobileVerifyBO);
        return lenderService.saveMobileVerify(lenderMobileVerifyBO) > 0;
    }

    @Override
    public String findBankCardNumber(Integer lenderId) {
        return lenderBankCardMapper.selectBankCardNumber(lenderId);
    }

    @Override
    public Integer findLenderId(String customerId) {
        return lenderMapper.selectPrimaryKeyByCustomerId(customerId);
    }

    @Override
    public Integer findAddressId(Integer lenderId) {
        return lenderAddressMapper.selectPrimaryKeyByLenderId(lenderId);
    }

    @Override
    public List<Integer> findContactIdList(Integer lenderId) {
        return lenderContactMapper.selectPrimaryKeyByLenderId(lenderId);
    }

    @Override
    public Integer findBankCardId(Integer lenderId) {
        return lenderBankCardMapper.selectPrimaryKeyByLenderId(lenderId);
    }

}
