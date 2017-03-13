package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ProcessState;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/13.
 */
public class ApplyCompleteStepBO implements Serializable {
    private static final long serialVersionUID = 882821748035170947L;

    /** 申请借款ID */
    private Integer apply_id;
    /** 结束时间 */
    private Date end_time;
    /** 处理时间 */
    private Date process_time;
    /** 处理状态（0失败、1成功、2中） */
    private ProcessState process_state;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
