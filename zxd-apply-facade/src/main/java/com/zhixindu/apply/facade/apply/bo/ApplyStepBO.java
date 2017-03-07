package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;

import java.io.Serializable;
import java.util.Date;

public class ApplyStepBO implements Serializable {

    private static final long serialVersionUID = -3234057634470113420L;
    /** 申请步骤ID */
    private Integer step_id;
    /** 申请借款ID */
    private Integer apply_id;
    /** 开始时间 */
    private Date start_time;
    /** 结束时间 */
    private Date end_time;
    /** 处理步骤（1提交申请、2审核、3放款） */
    private ProcessStep process_step;
    /** 处理时间 */
    private Date process_time;
    /** 处理状态（0失败、1成功、2中） */
    private ProcessState process_state;

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

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public ProcessStep getProcess_step() {
        return process_step;
    }

    public void setProcess_step(ProcessStep process_step) {
        this.process_step = process_step;
    }

    public Date getProcess_time() {
        return process_time;
    }

    public void setProcess_time(Date process_time) {
        this.process_time = process_time;
    }

    public ProcessState getProcess_state() {
        return process_state;
    }

    public void setProcess_state(ProcessState process_state) {
        this.process_state = process_state;
    }
}