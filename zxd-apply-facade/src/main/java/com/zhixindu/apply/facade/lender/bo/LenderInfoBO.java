package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

public class LenderInfoBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    /** 借款人ID */
    private Integer lender_id;

    private AddressBO addressBO;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public AddressBO getAddressBO() {
        return addressBO;
    }

    public void setAddressBO(AddressBO addressBO) {
        this.addressBO = addressBO;
    }
}