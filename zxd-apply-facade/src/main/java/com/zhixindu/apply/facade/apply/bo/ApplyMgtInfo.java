/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.bo.ApplyAddressMgtBO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class ApplyMgtInfo extends ApplyBaseInfoBO implements Serializable {
    private static final long serialVersionUID = 3670587372380106486L;

    /**申请时间**/
    private Date apply_time;

    /**
     * 地址
     */
    private ApplyAddressMgtBO applyAddressMgtBO;
    /**
     * 联系人
     */
    private List<ApplyContactBO> applyContactBOS;
    /**
     * 银行卡
     */
    private ApplyBankCardBO applyBankCardBO;

    public ApplyAddressMgtBO getApplyAddressMgtBO() {
        return applyAddressMgtBO;
    }

    public void setApplyAddressMgtBO(ApplyAddressMgtBO applyAddressMgtBO) {
        this.applyAddressMgtBO = applyAddressMgtBO;
    }

    public List<ApplyContactBO> getApplyContactBOS() {
        return applyContactBOS;
    }

    public void setApplyContactBOS(List<ApplyContactBO> applyContactBOS) {
        this.applyContactBOS = applyContactBOS;
    }

    public ApplyBankCardBO getApplyBankCardBO() {
        return applyBankCardBO;
    }

    public void setApplyBankCardBO(ApplyBankCardBO applyBankCardBO) {
        this.applyBankCardBO = applyBankCardBO;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }
}
