package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

public class LenderInfoBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    /** 填写步骤 */
    private int loan_fill_step;
    /** 借款人地址信息 */
    private LenderAddressBO lenderAddressBO;

    public int getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(int loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }

    public LenderAddressBO getLenderAddressBO() {
        return lenderAddressBO;
    }

    public void setLenderAddressBO(LenderAddressBO lenderAddressBO) {
        this.lenderAddressBO = lenderAddressBO;
    }
}