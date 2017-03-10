package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

public class LenderInfoBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    /** 借款人地址信息 */
    private LenderAddressBO lenderAddressBO;

    public LenderAddressBO getLenderAddressBO() {
        return lenderAddressBO;
    }

    public void setLenderAddressBO(LenderAddressBO lenderAddressBO) {
        this.lenderAddressBO = lenderAddressBO;
    }
}