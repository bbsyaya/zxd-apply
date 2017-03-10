package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.lender.bo.FillStepBO;
import com.zhixindu.apply.facade.lender.enums.FillStep;
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
    private LenderMapper lenderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        ApplyPO applyPO = new ApplyPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyPO);
        applyPO.setApply_time(new Date());
        applyPO.setApply_status(ApplyStatus.UNDER_REVIEW);
        int rows = applyMapper.insertSelective(applyPO);
        if(rows > 0) {
            FillStepBO fillStepBO = new FillStepBO(applyPO.getLender_id(), FillStep.COMPLETE);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        applyBaseInfoBO.setApply_id(applyPO.getApply_id());
        return rows;
    }

    @Override
    public String getLatestApplyStatus(Integer applyId) {
        ApplyStepBO applyStepBO = applyStepMapper.selectLatestByApplyId(applyId);
        return applyStepBO.getProcess_step().getDesc() + applyStepBO.getProcess_state().getDesc();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyStatus(ApplyStatusBO applyStatusBO) {
        return applyMapper.updateStatusByPrimaryKey(applyStatusBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyCredit(ApplyCreditBO applyCreditBO) {
        return applyMapper.updateCreditByPrimaryKey(applyCreditBO);
    }

}
