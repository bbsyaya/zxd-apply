package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyLoanStepBO implements Serializable{

    private static final long serialVersionUID = 2204700862297492400L;
    /**
     * 处理结果==步骤名称+处理状态描述
     */
    private String processing_result;

    /**
     * 处理时间
     */
    private String processing_time;

    public String getProcessing_result() {
        return processing_result;
    }

    public void setProcessing_result(String processing_result) {
        this.processing_result = processing_result;
    }

    public String getProcessing_time() {
        return processing_time;
    }

    public void setProcessing_time(String processing_time) {
        this.processing_time = processing_time;
    }

}
