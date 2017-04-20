/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

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
     * 申请ID
     **/
    private String apply_id;
    /**
     * 用户手机号
     **/
    private String mobile;
    /**
     * 用户身份证号
     **/
    private String id_card;
    /**
     * 申请人ID
     **/
    private String applicant_id;
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

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

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

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
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
