/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/7
 * @description
 */
public class ApplyMgtDetailBO implements Serializable {
    private static final long serialVersionUID = 2840701069750299567L;
    /**申请ID**/
    private Integer apply_id;
    /**申请人ID**/
    private String applicant_id;
    /**用户手机号**/
    private String mobile;
    /**用户姓名**/
    private String name;
    /**用户身份证号**/
    private String id_card;
    /**贷款金额**/
    private BigDecimal loan_amount;
    /**申请状态描述**/
    private String apply_status_desc;
    /**申请状态（1审核中、2审核成功、3审核失败、4放款中、5放款成功、6放款失败）**/
    private ApplyStatus apply_status;
    /**申请时间**/
    private Date apply_time;
    /**审核时间**/
    private Date review_time;
    /**放款时间**/
    private Date loan_time;

    public BigDecimal getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(BigDecimal loan_amount) {
        this.loan_amount = loan_amount;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
    }

    public Date getReview_time() {
        return review_time;
    }

    public void setReview_time(Date review_time) {
        this.review_time = review_time;
    }

    public Date getLoan_time() {
        return loan_time;
    }

    public void setLoan_time(Date loan_time) {
        this.loan_time = loan_time;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public String getApply_status_desc() {
        return this.apply_status_desc;
    }

    public void setApply_status_desc(String apply_status_desc) {
        this.apply_status_desc = apply_status_desc;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }
}
