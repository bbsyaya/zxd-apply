package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.lender.enums.LoanFillStep;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/6.
 */
@Service("lenderService")
public class LenderServiceImpl implements LenderService {

    @Inject
    private LenderMapper lenderMapper;
    @Inject
    private LenderAddressMapper lenderAddressMapper;
    @Inject
    private LenderContactMapper lenderContactMapper;
    @Inject
    private LenderBankCardMapper lenderBankCardMapper;

    @Override
    public boolean existLender(String customerId) {
        return lenderMapper.countByCustomerId(customerId) > 0;
    }

    @Override
    public boolean existLenderAddress(Integer lenderId) {
        return lenderAddressMapper.countByLenderId(lenderId) > 0;
    }

    @Override
    public boolean existLenderContact(Integer lenderId) {
        return lenderContactMapper.countByLenderId(lenderId) > 1;
    }

    @Override
    public boolean existLenderBankCard(Integer lenderId) {
        return lenderBankCardMapper.countByLenderId(lenderId) > 0;
    }

    @Override
    public boolean hasMobileVerified(Integer lenderId) {
        return null != lenderMapper.selectMobileVerifyByPrimaryKey(lenderId);
    }

    @Override
    public boolean hasBankCardVerified(Integer lenderId) {
        return null != lenderMapper.selectBankCardVerifyByPrimaryKey(lenderId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveLenderBaseInfo(LenderBaseInfoBO lenderBaseInfoBO) {
        LenderBaseInfoPO lenderBaseInfoPO = new LenderBaseInfoPO();
        BeanUtils.copyProperties(lenderBaseInfoBO, lenderBaseInfoPO);
        lenderBaseInfoPO.setLoan_fill_step(LoanFillStep.BASIC_INFO);
        lenderMapper.insertBaseInfo(lenderBaseInfoPO);
        lenderBaseInfoBO.setLender_id(lenderBaseInfoPO.getLender_id());
        return lenderBaseInfoPO.getLender_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateAddress(LenderAddressBO lenderAddressBO) {
        if(null != lenderAddressBO.getAddress_id()) {
            lenderAddressMapper.updateByPrimaryKey(lenderAddressBO);
        } else {
            lenderAddressMapper.insert(lenderAddressBO);
        }
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(lenderAddressBO.getLender_id(), LoanFillStep.CONTACT_INFO);
        lenderMapper.updateLoanFillStep(loanFillStepBO);
        return lenderAddressBO.getAddress_id();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> saveOrUpdateContact(List<LenderContactBO> lenderContactBOList) {
        List<Integer> contactIdList = lenderContactBOList.stream().map(contactBO -> {
            if (null != contactBO.getContact_id()) {
                lenderContactMapper.updateByPrimaryKey(contactBO);
            } else {
                int contactCount = lenderContactMapper.countByLenderId(contactBO.getLender_id());
                if(contactCount < 2){
                    lenderContactMapper.insert(contactBO);
                } else {
                    throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "contactId不能为空");
                }
            }
            return contactBO.getContact_id();
        }).collect(Collectors.toList());
        Integer lenderId = lenderContactBOList.stream().map(LenderContactBO::getLender_id).distinct().findAny().orElse(null);
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(lenderId, LoanFillStep.CERTIFICATION_INFO);
        lenderMapper.updateLoanFillStep(loanFillStepBO);
        return contactIdList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateBankCard(LenderBankCardBO lenderBankCardBO) {
        if(null != lenderBankCardBO.getBank_card_id()) {
            lenderBankCardMapper.updateByPrimaryKey(lenderBankCardBO);
        } else {
            lenderBankCardMapper.insert(lenderBankCardBO);
        }
        LenderBankCardVerifyBO lenderBankCardVerifyBO = new LenderBankCardVerifyBO();
        Integer lenderId = lenderBankCardBO.getLender_id();
        lenderBankCardVerifyBO.setLender_id(lenderId);
        lenderBankCardVerifyBO.setBank_card_verify(lenderBankCardBO.getBank_card_verify());
        lenderMapper.updateBankCardVerify(lenderBankCardVerifyBO);
        if(hasMobileVerified(lenderId)) {
            LoanFillStepBO loanFillStepBO = new LoanFillStepBO(lenderBankCardBO.getLender_id(), LoanFillStep.SUBMIT);
            lenderMapper.updateLoanFillStep(loanFillStepBO);
        }
        return lenderBankCardBO.getBank_card_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(LenderMobileVerifyBO mobileVerifyBO) {
        int rows = lenderMapper.updateMobileVerify(mobileVerifyBO);
        if(rows > 0 && hasBankCardVerified(mobileVerifyBO.getLender_id())) {
            LoanFillStepBO loanFillStepBO = new LoanFillStepBO(mobileVerifyBO.getLender_id(), LoanFillStep.SUBMIT);
            rows += lenderMapper.updateLoanFillStep(loanFillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int resetMobileVerify(Integer lenderId, String mobile) {
        return lenderMapper.resetMobileVerify(lenderId, mobile);
    }

}
