package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;

import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/20.
 */
public interface ApplyStepService {

    /**
     * 开启并完成步骤
     * @param applyId
     * @param processStep
     * @return
     */
    boolean startAndCompleteStep(Integer applyId, ProcessStep processStep);

    /**
     * 开启步骤
     * @param applyId
     * @param processStep
     * @return
     */
    boolean startStep(Integer applyId, ProcessStep processStep);

    /**
     * 完成步骤
     * @param applyId
     * @param processStep
     * @param processTime
     * @param processState
     * @return
     */
    boolean completeStep(Integer applyId, ProcessStep processStep, Date processTime, ProcessState processState);

}
