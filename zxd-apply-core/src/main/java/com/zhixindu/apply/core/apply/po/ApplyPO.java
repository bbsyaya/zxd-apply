package com.zhixindu.apply.core.apply.po;

import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ApplyPO extends ApplyBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 2181984961531019781L;
    /** 申请借款ID */
    private Integer apply_id;
    /** 日利率 */
    private Integer interest_rate;
    /** 借款利息 */
    private BigDecimal loan_interest;
    /** 平台管理费 */
    private BigDecimal platform_manage_fee;
    /** 申请时间 */
    private Date apply_time;
    /** 申请状态 */
    private ApplyStatus apply_status;
    /** 信用代码 */
    private String credit_code;
    /** 信用评分 */
    private Integer credit_score;
    /** 信用备忘录 */
    private String credit_memo;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Integer interest_rate) {
        this.interest_rate = interest_rate;
    }

    public BigDecimal getLoan_interest() {
        return loan_interest;
    }

    public void setLoan_interest(BigDecimal loan_interest) {
        this.loan_interest = loan_interest;
    }

    public BigDecimal getPlatform_manage_fee() {
        return platform_manage_fee;
    }

    public void setPlatform_manage_fee(BigDecimal platform_manage_fee) {
        this.platform_manage_fee = platform_manage_fee;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public String getCredit_memo() {
        return credit_memo;
    }

    public void setCredit_memo(String credit_memo) {
        this.credit_memo = credit_memo;
    }
}