package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.FillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class FillStepBO implements Serializable {
    private static final long serialVersionUID = -2873703555509810673L;

    /** 借款人ID */
    private Integer lender_id;
    /** 填写步骤 */
    private FillStep fill_step;

    public FillStepBO(Integer lender_id, FillStep fill_step) {
        this.lender_id = lender_id;
        this.fill_step = fill_step;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public FillStep getFill_step() {
        return fill_step;
    }

    public void setFill_step(FillStep fill_step) {
        this.fill_step = fill_step;
    }
}
