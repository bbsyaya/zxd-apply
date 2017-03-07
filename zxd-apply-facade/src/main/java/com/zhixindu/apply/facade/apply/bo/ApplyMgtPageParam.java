/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.workflow.enums.ProcessStep;
import com.zhixindu.apply.facade.workflow.enums.ProcessState;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class ApplyMgtPageParam extends ApplyPageParam implements Serializable {

    private static final long serialVersionUID = -3851235801784011500L;
    /**
     * 用户手机号
     **/
    private String mobile;
    /**
     * 用户身份证号
     **/
    private String id_card;
    /**
     * 申请ID
     **/
    private String lender_id;
    /**
     * 申请状态 1审核中，2审核成功，3审核失败，4放款成功，5放款失败
     **/
    private ApplyStatus apply_status;
    /**
     * 申请开始时间
     **/
    private Date apply_start_time;
    /**
     * 申请结束时间
     **/
    private Date apply_end_time;
    /**
     * 流程步骤定义
     */
    private ProcessStep step_definition;
    /**
     * 流程步骤状态
     */
    private ProcessState step_state;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getLender_id() {
        return lender_id;
    }

    public void setLender_id(String lender_id) {
        this.lender_id = lender_id;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
    }

    public ProcessStep getStep_definition() {
        return apply_status.getStepDefinition();
    }

    public void setStep_definition(ProcessStep step_definition) {
        this.step_definition = step_definition;
    }

    public ProcessState getStep_state() {
        return apply_status.getStepState();
    }

    public void setStep_state(ProcessState step_state) {
        this.step_state = step_state;
    }

    public Date getApply_start_time() {
        return apply_start_time;
    }

    public void setApply_start_time(Date apply_start_time) {
        this.apply_start_time = apply_start_time;
    }

    public Date getApply_end_time() {
        return apply_end_time;
    }

    public void setApply_end_time(Date apply_end_time) {
        this.apply_end_time = apply_end_time;
    }

}
