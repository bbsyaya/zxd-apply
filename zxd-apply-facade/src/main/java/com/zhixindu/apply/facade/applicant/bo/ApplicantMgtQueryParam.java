/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.commons.page.PageParam;

import java.io.Serializable;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class ApplicantMgtQueryParam implements Serializable,PageParam {

    private static final long serialVersionUID = 5342367705354369028L;
    /**页数**/
    private int page = 0;
    /**每页大小**/
    private int count = 10;

    @Override
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
