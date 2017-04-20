/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/4/5
 * @description
 */
public class ApplyBankCardMgtBO extends ApplyBankCardBO implements Serializable {
    private static final long serialVersionUID = -6028115777381291528L;

    private String bank_address_info;

    public String getBank_address_info() {
        return bank_address_info;
    }

    public void setBank_address_info(String bank_address_info) {
        this.bank_address_info = bank_address_info;
    }
}
