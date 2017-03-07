package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.util.Date;

public class ApplyStepBO implements Serializable {
    private Integer step_id;

    private Integer apply_id;

    private Date start_time;

    private Date end_time;

    private Integer process_step;

    private Date process_time;

    private Integer process_state;

    private static final long serialVersionUID = 1L;

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

    public Integer getProcess_step() {
        return process_step;
    }

    public void setProcess_step(Integer process_step) {
        this.process_step = process_step;
    }

    public Date getProcess_time() {
        return process_time;
    }

    public void setProcess_time(Date process_time) {
        this.process_time = process_time;
    }

    public Integer getProcess_state() {
        return process_state;
    }

    public void setProcess_state(Integer process_state) {
        this.process_state = process_state;
    }
}