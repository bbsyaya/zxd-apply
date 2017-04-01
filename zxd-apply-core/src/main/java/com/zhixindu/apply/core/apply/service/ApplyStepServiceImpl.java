package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyCompleteStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStartStepBO;
import com.zhixindu.apply.core.apply.po.ApplyStepPO;
import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/20.
 */
@Service("applyStepService")
public class ApplyStepServiceImpl implements ApplyStepService {

    @Inject
    private ApplyStepMapper applyStepMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean startAndCompleteStep(Integer applyId, ProcessStep processStep) {
        ApplyStepPO applyStepPO = new ApplyStepPO();
        applyStepPO.setApply_id(applyId);
        Date now = new Date();
        applyStepPO.setStart_time(now);
        applyStepPO.setEnd_time(now);
        applyStepPO.setProcess_step(processStep);
        applyStepPO.setProcess_time(now);
        applyStepPO.setProcess_state(ProcessState.SUCCESS);
        return applyStepMapper.insertSelective(applyStepPO) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean startStep(Integer applyId, ProcessStep processStep) {
        ApplyStartStepBO applyStartStepBO = new ApplyStartStepBO();
        applyStartStepBO.setApply_id(applyId);
        applyStartStepBO.setStart_time(new Date());
        applyStartStepBO.setProcess_step(processStep);
        applyStartStepBO.setProcess_state(ProcessState.PROCESSING);
        return applyStepMapper.startStep(applyStartStepBO) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean completeStep(Integer applyId, ProcessStep processStep, Date processTime, ProcessState processState) {
        ApplyCompleteStepBO completeStepBO = new ApplyCompleteStepBO();
        completeStepBO.setApply_id(applyId);
        completeStepBO.setEnd_time(new Date());
        completeStepBO.setProcess_step(processStep);
        completeStepBO.setProcess_time(processTime);
        completeStepBO.setProcess_state(processState);
        return applyStepMapper.completeStep(completeStepBO) > 0;
    }
}
