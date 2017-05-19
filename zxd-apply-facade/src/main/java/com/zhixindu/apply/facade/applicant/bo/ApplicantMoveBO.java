/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.applicant.bo;

import java.io.Serializable;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/5/19
 * @description 迁移的申请信息
 */
public class ApplicantMoveBO  extends ApplicantBO implements Serializable {
    private static final long serialVersionUID = -7510309567533053696L;
    /**申请ID**/
    private Integer apply_id;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }
}
