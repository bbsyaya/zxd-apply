package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyLoanBO implements Serializable {

    private static final long serialVersionUID = 6811852626457403898L;

    /**
     * 申请贷款ID
     */
    private Integer apply_id;
    /**
     * 申请时间
     */
    private String apply_time;
    /**
     * 借款金额
     */
    private BigDecimal loan_amount;
    /**
     * 到账金额
     */
    private BigDecimal account_amount;
    /**
     * 申请状态
     */
    private String apply_status;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public BigDecimal getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(BigDecimal loan_amount) {
        this.loan_amount = loan_amount;
    }

    public BigDecimal getAccount_amount() {
        return account_amount;
    }

    public void setAccount_amount(BigDecimal account_amount) {
        this.account_amount = account_amount;
    }

    public String getApply_status() {
        return apply_status;
    }

    public void setApply_status(String apply_status) {
        this.apply_status = apply_status;
    }
}
