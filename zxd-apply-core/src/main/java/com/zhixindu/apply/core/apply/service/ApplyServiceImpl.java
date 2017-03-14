package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLocationBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStartStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import com.zhixindu.apply.facade.apply.enums.ApplyResultStatusMapping;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LoanFillStepBO;
import com.zhixindu.apply.facade.lender.enums.ApplyResult;
import com.zhixindu.apply.facade.lender.enums.LoanFillStep;
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
    private ApplyStepMapper applyStepMapper;
    @Inject
    private ApplyLocationMapper applyLocationMapper;
    @Inject
    private LenderMapper lenderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        ApplyPO applyPO = new ApplyPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyPO);
        applyPO.setApply_time(new Date());
        applyPO.setApply_status(ApplyStatus.UNDER_REVIEW);
        applyMapper.insertSelective(applyPO);

        ApplyLocationBO applyLocationBO = new ApplyLocationBO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyLocationBO);
        applyLocationBO.setApply_id(applyPO.getApply_id());
        applyLocationMapper.insert(applyLocationBO);

        ApplyStepBO applyStepBO = new ApplyStepBO();
        applyStepBO.setApply_id(applyPO.getApply_id());
        Date now = new Date();
        applyStepBO.setStart_time(now);
        applyStepBO.setEnd_time(now);
        applyStepBO.setProcess_step(ProcessStep.SUBMIT_APPLICATION);
        applyStepBO.setProcess_time(now);
        applyStepBO.setProcess_state(ProcessState.SUCCESS);
        applyStepMapper.insertSelective(applyStepBO);

        ApplyStartStepBO applyStartStepBO = new ApplyStartStepBO();
        applyStartStepBO.setApply_id(applyPO.getApply_id());
        applyStartStepBO.setStart_time(now);
        applyStartStepBO.setProcess_step(ProcessStep.REVIEW);
        applyStartStepBO.setProcess_state(ProcessState.PROCESSING);
        applyStepMapper.startStep(applyStartStepBO);

        LoanFillStepBO loanFillStepBO = new LoanFillStepBO(applyPO.getLender_id(), LoanFillStep.COMPLETE);
        lenderMapper.updateLoanFillStep(loanFillStepBO);
        applyBaseInfoBO.setApply_id(applyPO.getApply_id());
        return applyPO.getApply_id();
    }

    @Override
    public String getLatestApplyStatus(Integer applyId) {
        ApplyStepBO applyStepBO = applyStepMapper.selectLatestByApplyId(applyId);
        return applyStepBO.getProcess_step().getDesc() + applyStepBO.getProcess_state().getDesc();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateLoanStatus(ApplyStatusBO applyStatusBO) {
        return applyMapper.updateStatusByPrimaryKey(applyStatusBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyCredit(ApplyCreditBO applyCreditBO) {
        int rows = applyMapper.updateCreditByPrimaryKey(applyCreditBO);

        ApplyResultBO applyResultBO = new ApplyResultBO();
        applyResultBO.setLender_id(applyMapper.selectLenderIdByPrimaryKey(applyCreditBO.getApply_id()));
        applyResultBO.setCredit_score(applyCreditBO.getCredit_score());
        ApplyResult applyResult = ApplyResultStatusMapping.getApplyResult(applyCreditBO.getApply_status());
        applyResultBO.setApply_result(applyResult);
        // 审核失败才会更新审核拒绝时间
        if(ApplyStatus.REVIEW_FAIL.matches(applyCreditBO.getApply_status())) {
            applyResultBO.setReject_time(new Date());
        }
        rows += lenderMapper.updateApplyResult(applyResultBO);


        return rows;
    }

}
