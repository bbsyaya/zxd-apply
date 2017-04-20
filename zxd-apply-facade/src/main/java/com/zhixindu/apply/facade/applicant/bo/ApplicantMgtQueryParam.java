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
    /**
     * 申请人姓名
     */
    private String name;
    /**
     * 用户手机号
     **/
    private String mobile;
    /**
     * 用户身份证号
     **/
    private String id_card;
    /**
     * 申请人ID
     **/
    private String applicant_id;
    /**页数**/
    private int page = 0;
    /**每页大小**/
    private int count = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

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
