package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.LoanFillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class LoanFillStepBO implements Serializable {
    private static final long serialVersionUID = -2873703555509810673L;

    /** 借款人ID */
    private Integer lender_id;
    /** 填写步骤 */
    private LoanFillStep loan_fill_step;

    public LoanFillStepBO(Integer lender_id, LoanFillStep loan_fill_step) {
        this.lender_id = lender_id;
        this.loan_fill_step = loan_fill_step;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public LoanFillStep getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(LoanFillStep loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }
}
