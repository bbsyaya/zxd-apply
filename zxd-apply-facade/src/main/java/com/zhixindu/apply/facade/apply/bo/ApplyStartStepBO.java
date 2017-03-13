package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/13.
 */
public class ApplyStartStepBO implements Serializable {
    private static final long serialVersionUID = -4654908730844665378L;

    /** 申请步骤ID */
    private Integer step_id;
    /** 申请借款ID */
    private Integer apply_id;
    /** 开始时间 */
    private Date start_time;
    /** 处理步骤（1提交申请、2审核、3放款） */
    private ProcessStep process_step;
    /** 处理状态（0失败、1成功、2中） */
    private ProcessState process_state = ProcessState.PROCESSING;

    public Integer getStep_id() {
        return step_id;
    }

    public void setStep_id(Integer step_id) {
        this.step_id = step_id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public ProcessStep getProcess_step() {
        return process_step;
    }

    public void setProcess_step(ProcessStep process_step) {
        this.process_step = process_step;
    }

    public ProcessState getProcess_state() {
        return process_state;
    }

    public void setProcess_state(ProcessState process_state) {
        this.process_state = process_state;
    }
}
