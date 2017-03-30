package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/29.
 */
public class ApplyLoanInfoBO implements Serializable {
    private static final long serialVersionUID = 3198690751855362178L;

    /** 申请ID */
    private Integer apply_id;
    /** 申请地址信息 */
    private ApplyAddressBO applyAddressBO;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public ApplyAddressBO getApplyAddressBO() {
        return applyAddressBO;
    }

    public void setApplyAddressBO(ApplyAddressBO applyAddressBO) {
        this.applyAddressBO = applyAddressBO;
    }
}
