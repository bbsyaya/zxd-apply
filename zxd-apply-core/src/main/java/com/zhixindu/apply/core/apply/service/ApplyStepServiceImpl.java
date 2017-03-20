package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyCompleteStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStartStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
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
        ApplyStepBO applyStepBO = new ApplyStepBO();
        applyStepBO.setApply_id(applyId);
        Date now = new Date();
        applyStepBO.setStart_time(now);
        applyStepBO.setEnd_time(now);
        applyStepBO.setProcess_step(processStep);
        applyStepBO.setProcess_time(now);
        applyStepBO.setProcess_state(ProcessState.SUCCESS);
        return applyStepMapper.insertSelective(applyStepBO) > 0;
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
