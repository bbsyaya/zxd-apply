package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyLoanStepBO implements Serializable{

    private static final long serialVersionUID = 2204700862297492400L;
    /** 处理结果==步骤名称+处理状态描述 */
    private String process_result;
    /** 处理时间 */
    private String process_time;

    public String getProcess_result() {
        return process_result;
    }

    public void setProcess_result(String process_result) {
        this.process_result = process_result;
    }

    public String getProcess_time() {
        return process_time;
    }

    public void setProcess_time(String process_time) {
        this.process_time = process_time;
    }

}
