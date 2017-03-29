package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;

import java.io.Serializable;

public class ApplicantInfoBO extends ApplicantBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    /** 填写步骤 */
    private int loan_fill_step;
    /** 申请地址信息 */
    private ApplyAddressBO applyAddressBO;

    public int getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(int loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }

    public ApplyAddressBO getApplyAddressBO() {
        return applyAddressBO;
    }

    public void setApplyAddressBO(ApplyAddressBO applyAddressBO) {
        this.applyAddressBO = applyAddressBO;
    }
}