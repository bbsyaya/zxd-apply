package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public class ApplyStatusBO implements Serializable {

    private static final long serialVersionUID = -4949931936315966918L;

    /** 申请借款ID */
    private Integer apply_id;
    /** 申请状态 */
    private ApplyStatus apply_status;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
    }
}
