package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.service.ApplicantService;
import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.po.ApplyAddressPO;
import com.zhixindu.apply.core.apply.po.ApplyBankCardPO;
import com.zhixindu.apply.core.apply.po.ApplyContactPO;
import com.zhixindu.apply.core.apply.po.ApplyLocationPO;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;
import com.zhixindu.apply.facade.applicant.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardVerifyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/7.
 */
@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyAddressMapper applyAddressMapper;
    @Inject
    private ApplyContactMapper applyContactMapper;
    @Inject
    private ApplyBankCardMapper applyBankCardMapper;
    @Inject
    private ApplyLocationMapper applyLocationMapper;
    @Inject
    private ApplyStepService applyStepService;
    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplicantService applicantService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer startApplyLoan(Integer applicantId) {
        ApplyPO applyPO = new ApplyPO();
        applyPO.setApplicant_id(applicantId);
        applyPO.setApply_status(ApplyStatus.PREPARE_SUBMIT);
        applyMapper.insertSelective(applyPO);
        Integer applyId = applyPO.getApply_id();

        applyStepService.startStep(applyId, ProcessStep.SUBMIT);

        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applicantId, LoanFillStep.BASIC_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return applyId;
    }

    @Override
    public boolean existApplyAddress(Integer applicantId) {
        return applyAddressMapper.countByApplyId(applicantId) > 0;
    }

    @Override
    public boolean existApplyContact(Integer applicantId) {
        return applyContactMapper.countByApplyId(applicantId) > 1;
    }

    @Override
    public boolean existApplyBankCard(Integer applicantId) {
        return applyBankCardMapper.countByApplyId(applicantId) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateAddress(ApplyAddressBO applyAddressBO) {
        ApplyAddressPO applyAddressPO = new ApplyAddressPO();
        BeanUtils.copyProperties(applyAddressBO, applyAddressPO);
        if(null != applyAddressBO.getAddress_id()) {
            applyAddressMapper.updateByPrimaryKey(applyAddressPO);
        } else {
            applyAddressPO.setCreate_time(new Date());
            applyAddressMapper.insert(applyAddressPO);
            applyAddressBO.setAddress_id(applyAddressPO.getAddress_id());
        }
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applyAddressBO.getApplicant_id(), LoanFillStep.CONTACT_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return applyAddressBO.getAddress_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> saveOrUpdateContact(List<ApplyContactBO> applyContactBOList) {
        List<Integer> contactIdList = applyContactBOList.stream().map(applyContactBO -> {
            ApplyContactPO applyContactPO = new ApplyContactPO();
            BeanUtils.copyProperties(applyContactBO, applyContactPO);
            if (null != applyContactBO.getContact_id()) {
                applyContactMapper.updateByPrimaryKey(applyContactPO);
            } else {
                int contactCount = applyContactMapper.countByApplyId(applyContactBO.getApplicant_id());
                if(contactCount < 2){
                    applyContactPO.setCreate_time(new Date());
                    applyContactMapper.insert(applyContactPO);
                    applyContactBO.setContact_id(applyContactPO.getContact_id());
                } else {
                    throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "contactId不能为空");
                }
            }
            return applyContactBO.getContact_id();
        }).collect(Collectors.toList());
        Integer applicantId = applyContactBOList.stream().map(ApplyContactBO::getApplicant_id).distinct().findAny().orElse(null);
        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applicantId, LoanFillStep.CERTIFICATION_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return contactIdList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateBankCard(ApplyBankCardBO applyBankCardBO) {
        ApplyBankCardPO applyBankCardPO = new ApplyBankCardPO();
        BeanUtils.copyProperties(applyBankCardBO, applyBankCardPO);
        if(null != applyBankCardBO.getBank_card_id()) {
            applyBankCardMapper.updateByPrimaryKey(applyBankCardPO);
        } else {
            applyBankCardPO.setCreate_time(new Date());
            applyBankCardMapper.insert(applyBankCardPO);
            applyBankCardBO.setBank_card_id(applyBankCardPO.getBank_card_id());
        }
        ApplyBankCardVerifyBO applyBankCardVerifyBO = new ApplyBankCardVerifyBO();
        Integer applicantId = applyBankCardBO.getApplicant_id();
        applyBankCardVerifyBO.setApplicant_id(applicantId);
        applyBankCardVerifyBO.setBank_card_verify(applyBankCardBO.getBank_card_verify());
        applicantMapper.updateBankCardVerify(applyBankCardVerifyBO);
        if(applicantService.hasMobileVerified(applicantId)) {
            LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applyBankCardBO.getApplicant_id(), LoanFillStep.SUBMIT);
            applicantMapper.updateLoanFillStep(loanFillStepBO);
        }
        return applyBankCardBO.getBank_card_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        ApplyPO applyPO = new ApplyPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyPO);
        Date now = new Date();
        applyPO.setApply_time(now);
        applyPO.setApply_status(ApplyStatus.UNDER_REVIEW);
        applyMapper.updateByPrimaryKeySelective(applyPO);

        ApplyLocationPO applyLocationPO = new ApplyLocationPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyLocationPO);
        applyLocationPO.setCreate_time(new Date());
        applyLocationMapper.insert(applyLocationPO);

        Integer applyId = applyBaseInfoBO.getApply_id();
        applyStepService.completeStep(applyId, ProcessStep.SUBMIT, now, ProcessState.SUCCESS);
        applyStepService.startStep(applyId, ProcessStep.REVIEW);

        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applyPO.getApplicant_id(), LoanFillStep.COMPLETE);
        applicantMapper.updateLoanFillStep(loanFillStepBO);
        return applyPO.getApply_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyCredit(ApplyCreditBO applyCreditBO) {
        int rows = applyMapper.updateCreditByPrimaryKey(applyCreditBO);

        ApplyResultBO applyResultBO = new ApplyResultBO();
        Integer applyId = applyCreditBO.getApply_id();
        applyResultBO.setApplicant_id(applyMapper.selectApplicantIdByPrimaryKey(applyId));
        applyResultBO.setCredit_score(applyCreditBO.getCredit_score());
        applyResultBO.setApply_result(applyCreditBO.getApply_status().getApplyResult());
        // 审核失败才会更新审核拒绝时间
        if(ApplyStatus.REVIEW_FAIL.matches(applyCreditBO.getApply_status())) {
            applyResultBO.setReject_time(new Date());
        }
        rows += applicantMapper.updateApplyResult(applyResultBO);

        ProcessState processState = applyCreditBO.getApply_status().getProcessState();
        applyStepService.completeStep(applyId, ProcessStep.REVIEW, applyCreditBO.getReview_time(), processState);
        // 审核成功才有下一步放款
        if(ApplyStatus.REVIEW_SUCCESS.matches(applyCreditBO.getApply_status())) {
            applyStepService.startStep(applyId, ProcessStep.LOAN);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateLoanStatus(ApplyStatusBO applyStatusBO) {
        int rows = applyMapper.updateStatusByPrimaryKey(applyStatusBO);

        Integer applyId = applyStatusBO.getApply_id();
        ProcessState processState = applyStatusBO.getApply_status().getProcessState();
        applyStepService.completeStep(applyId, ProcessStep.LOAN, applyStatusBO.getProcess_time(), processState);
        // 放款成功才有下一步结清
        if(ApplyStatus.LOAN_SUCCESS.matches(applyStatusBO.getApply_status())) {
            applyStepService.startStep(applyId, ProcessStep.REPAYMENT);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateRepaymentStatus(ApplyStatusBO applyStatusBO) {
        applyStatusBO.setApply_status(ApplyStatus.REPAYMENT_SETTLED);
        int rows = applyMapper.updateStatusByPrimaryKey(applyStatusBO);

        ProcessState processState = applyStatusBO.getApply_status().getProcessState();
        applyStepService.completeStep(applyStatusBO.getApply_id(), ProcessStep.REPAYMENT, applyStatusBO.getProcess_time(), processState);
        return rows;
    }

}
