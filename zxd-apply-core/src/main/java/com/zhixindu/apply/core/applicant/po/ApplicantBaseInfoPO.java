package com.zhixindu.apply.core.applicant.po;

import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class ApplicantBaseInfoPO extends ApplicantBaseInfoBO implements Serializable {
    private static final long serialVersionUID = -8597801638856657035L;

    /** 填写步骤 */
    private LoanFillStep loan_fill_step;

    public LoanFillStep getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(LoanFillStep loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }
}
