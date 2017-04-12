package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.apply.po.ApplyCompleteStepPO;
import com.zhixindu.apply.core.apply.po.ApplyStartStepPO;
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
        ApplyStartStepPO applyStartStepPO = new ApplyStartStepPO();
        applyStartStepPO.setApply_id(applyId);
        applyStartStepPO.setStart_time(new Date());
        applyStartStepPO.setProcess_step(processStep);
        applyStartStepPO.setProcess_state(ProcessState.PROCESSING);
        return applyStepMapper.startStep(applyStartStepPO) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean completeStep(Integer applyId, ProcessStep processStep, Date processTime, ProcessState processState) {
        ApplyCompleteStepPO completeStepPO = new ApplyCompleteStepPO();
        completeStepPO.setApply_id(applyId);
        completeStepPO.setEnd_time(new Date());
        completeStepPO.setProcess_step(processStep);
        completeStepPO.setProcess_time(processTime);
        completeStepPO.setProcess_state(processState);
        return applyStepMapper.completeStep(completeStepPO) > 0;
    }
}
