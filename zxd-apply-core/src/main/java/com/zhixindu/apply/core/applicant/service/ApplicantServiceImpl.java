package com.zhixindu.apply.core.applicant.service;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.po.ApplicantBaseInfoPO;
import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import com.zhixindu.apply.facade.applicant.enums.MobileVerify;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardVerifyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
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
public class ApplicantServiceImpl implements ApplicantService {

    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplyAddressMapper applyAddressMapper;
    @Inject
    private ApplyContactMapper applyContactMapper;
    @Inject
    private ApplyBankCardMapper applyBankCardMapper;

    @Override
    public boolean existApplicant(String customerId) {
        return applicantMapper.countByCustomerId(customerId) > 0;
    }

    @Override
    public boolean existApplicantAddress(Integer applicantId) {
        return applyAddressMapper.countByApplicantId(applicantId) > 0;
    }

    @Override
    public boolean existApplicantContact(Integer applicantId) {
        return applyContactMapper.countByApplicantId(applicantId) > 1;
    }

    @Override
    public boolean existApplicantBankCard(Integer applicantId) {
        return applyBankCardMapper.countByApplicantId(applicantId) > 0;
    }

    @Override
    public boolean hasMobileVerified(Integer applicantId) {
        Integer mobileVerify = applicantMapper.selectMobileVerifyByPrimaryKey(applicantId);
        return null != mobileVerify && MobileVerify.VERIFIED.matches(mobileVerify);
    }

    @Override
    public boolean hasBankCardVerified(Integer applicantId) {
        Integer bankCardVerify = applicantMapper.selectBankCardVerifyByPrimaryKey(applicantId);
        return null != bankCardVerify && BankCardVerify.VERIFIED.matches(bankCardVerify);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveApplicantBaseInfo(ApplicantBaseInfoBO lenderBaseInfoBO) {
        ApplicantBaseInfoPO applicantBaseInfoPO = new ApplicantBaseInfoPO();
        BeanUtils.copyProperties(lenderBaseInfoBO, applicantBaseInfoPO);
        applicantBaseInfoPO.setLoan_fill_step(LoanFillStep.BASIC_INFO);
        applicantMapper.insertBaseInfo(applicantBaseInfoPO);
        lenderBaseInfoBO.setApplicant_id(applicantBaseInfoPO.getApplicant_id());
        return applicantBaseInfoPO.getApplicant_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateAddress(ApplyAddressBO lenderAddressBO) {
        if(null != lenderAddressBO.getAddress_id()) {
            applyAddressMapper.updateByPrimaryKey(lenderAddressBO);
        } else {
            applyAddressMapper.insert(lenderAddressBO);
        }
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(lenderAddressBO.getApplicant_id(), LoanFillStep.CONTACT_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return lenderAddressBO.getAddress_id();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> saveOrUpdateContact(List<ApplyContactBO> lenderContactBOList) {
        List<Integer> contactIdList = lenderContactBOList.stream().map(contactBO -> {
            if (null != contactBO.getContact_id()) {
                applyContactMapper.updateByPrimaryKey(contactBO);
            } else {
                int contactCount = applyContactMapper.countByApplicantId(contactBO.getApplicant_id());
                if(contactCount < 2){
                    applyContactMapper.insert(contactBO);
                } else {
                    throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "contactId不能为空");
                }
            }
            return contactBO.getContact_id();
        }).collect(Collectors.toList());
        Integer applicantId = lenderContactBOList.stream().map(ApplyContactBO::getApplicant_id).distinct().findAny().orElse(null);
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applicantId, LoanFillStep.CERTIFICATION_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return contactIdList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateBankCard(ApplyBankCardBO lenderBankCardBO) {
        if(null != lenderBankCardBO.getBank_card_id()) {
            applyBankCardMapper.updateByPrimaryKey(lenderBankCardBO);
        } else {
            applyBankCardMapper.insert(lenderBankCardBO);
        }
        ApplyBankCardVerifyBO lenderBankCardVerifyBO = new ApplyBankCardVerifyBO();
        Integer applicantId = lenderBankCardBO.getApplicant_id();
        lenderBankCardVerifyBO.setApplicant_id(applicantId);
        lenderBankCardVerifyBO.setBank_card_verify(lenderBankCardBO.getBank_card_verify());
        applicantMapper.updateBankCardVerify(lenderBankCardVerifyBO);
        if(hasMobileVerified(applicantId)) {
            LoanFillStepBO loanFillStepBO = new LoanFillStepBO(lenderBankCardBO.getApplicant_id(), LoanFillStep.SUBMIT);
            applicantMapper.updateLoanFillStep(loanFillStepBO);
        }
        return lenderBankCardBO.getBank_card_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(ApplicantMobileVerifyBO mobileVerifyBO) {
        int rows = applicantMapper.updateMobileVerify(mobileVerifyBO);
        if(rows > 0 && hasBankCardVerified(mobileVerifyBO.getApplicant_id())) {
            LoanFillStepBO loanFillStepBO = new LoanFillStepBO(mobileVerifyBO.getApplicant_id(), LoanFillStep.SUBMIT);
            rows += applicantMapper.updateLoanFillStep(loanFillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int resetMobileVerify(Integer applicantId, String mobile) {
        return applicantMapper.resetMobileVerify(applicantId, mobile);
    }

}
