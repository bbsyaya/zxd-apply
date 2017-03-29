package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class LoanFillStepBO implements Serializable {
    private static final long serialVersionUID = -2873703555509810673L;

    /** 申请人ID */
    private Integer applicant_id;
    /** 填写步骤 */
    private LoanFillStep loan_fill_step;

    public LoanFillStepBO(Integer applicant_id, LoanFillStep loan_fill_step) {
        this.applicant_id = applicant_id;
        this.loan_fill_step = loan_fill_step;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public LoanFillStep getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(LoanFillStep loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }
}
