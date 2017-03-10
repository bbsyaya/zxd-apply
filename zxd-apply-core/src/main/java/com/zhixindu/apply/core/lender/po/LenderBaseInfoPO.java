package com.zhixindu.apply.core.lender.po;

import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.enums.FillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class LenderBaseInfoPO extends LenderBaseInfoBO implements Serializable {
    private static final long serialVersionUID = -8597801638856657035L;

    /** 填写步骤 */
    private FillStep fill_step;

    public FillStep getFill_step() {
        return fill_step;
    }

    public void setFill_step(FillStep fill_step) {
        this.fill_step = fill_step;
    }
}
