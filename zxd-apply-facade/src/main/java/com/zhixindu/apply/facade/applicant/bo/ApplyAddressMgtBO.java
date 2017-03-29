/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;

import java.io.Serializable;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/13
 * @description
 */
public class ApplyAddressMgtBO extends ApplyAddressBO implements Serializable {
    private static final long serialVersionUID = -8931918025922311665L;

    private String  home_address_info;

    private String  company_address_info;

    public String getHome_address_info() {
        return home_address_info;
    }

    public void setHome_address_info(String home_address_info) {
        this.home_address_info = home_address_info;
    }

    public String getCompany_address_info() {
        return company_address_info;
    }

    public void setCompany_address_info(String company_address_info) {
        this.company_address_info = company_address_info;
    }
}
