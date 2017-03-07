/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class ApplyMgtInfo implements Serializable {
    private static final long serialVersionUID = 3670587372380106486L;
    /**申请Id **/
    private Integer lender_id;
    /**申请金额 **/
    private BigDecimal loan_amount;
    /**申请期限 **/
    private int loan_term;
    /**日利率**/
    private int interest_rate;
    /**借款利息**/
    private BigDecimal loan_interest;
    /**平台管理费**/
    private BigDecimal platform_manage_fee;
    /**到期还款**/
    private BigDecimal repayment_amount;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public BigDecimal getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(BigDecimal loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(int loan_term) {
        this.loan_term = loan_term;
    }

    public int getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(int interest_rate) {
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

    public BigDecimal getRepayment_amount() {
        return repayment_amount;
    }

    public void setRepayment_amount(BigDecimal repayment_amount) {
        this.repayment_amount = repayment_amount;
    }
}
