package com.zhixindu.apply.core.applicant.service;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.po.ApplicantBaseInfoPO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import com.zhixindu.apply.facade.applicant.enums.MobileVerify;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/6.
 */
@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService {

    @Inject
    private ApplicantMapper applicantMapper;

    @Override
    public boolean existApplicant(String customerId) {
        return applicantMapper.countByCustomerId(customerId) > 0;
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
    public Integer saveApplicantBaseInfo(ApplicantBaseInfoBO applicantBaseInfoBO) {
        ApplicantBaseInfoPO applicantBaseInfoPO = new ApplicantBaseInfoPO();
        BeanUtils.copyProperties(applicantBaseInfoBO, applicantBaseInfoPO);
        applicantBaseInfoPO.setLoan_fill_step(LoanFillStep.BASIC_INFO);
        applicantMapper.insertBaseInfo(applicantBaseInfoPO);
        applicantBaseInfoBO.setApplicant_id(applicantBaseInfoPO.getApplicant_id());
        return applicantBaseInfoPO.getApplicant_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(ApplicantMobileVerifyBO mobileVerifyBO) {
        int rows = applicantMapper.updateMobileVerify(mobileVerifyBO);
        // 必须是手机号认证通过且银行卡已经认证通过才能更新填写步骤
        if(rows == 1 && MobileVerify.VERIFIED.matches(mobileVerifyBO.getMobile_verify())
                && hasBankCardVerified(mobileVerifyBO.getApplicant_id())) {
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
