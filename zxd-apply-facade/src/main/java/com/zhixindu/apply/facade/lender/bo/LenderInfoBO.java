package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

public class LenderInfoBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    /** 借款人地址信息 */
    private AddressBO addressBO;

    public AddressBO getAddressBO() {
        return addressBO;
    }

    public void setAddressBO(AddressBO addressBO) {
        this.addressBO = addressBO;
    }
}