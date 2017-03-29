package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLocationBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;
import com.zhixindu.apply.facade.applicant.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/7.
 */
@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyLocationMapper applyLocationMapper;
    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplyStepService applyStepService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        ApplyPO applyPO = new ApplyPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyPO);
        applyPO.setApply_time(new Date());
        applyPO.setApply_status(ApplyStatus.UNDER_REVIEW);
        applyMapper.insertSelective(applyPO);
        Integer applyId = applyPO.getApply_id();
        applyBaseInfoBO.setApply_id(applyId);

        ApplyLocationBO applyLocationBO = new ApplyLocationBO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyLocationBO);
        applyLocationBO.setApply_id(applyId);
        applyLocationMapper.insert(applyLocationBO);

        applyStepService.startAndCompleteStep(applyId, ProcessStep.SUBMIT);

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
