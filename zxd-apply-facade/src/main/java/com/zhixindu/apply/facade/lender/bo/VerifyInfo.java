/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class VerifyInfo implements Serializable {

    private static final long serialVersionUID = -4614504408406096237L;

    private Integer bank_card_verify;

    private String bank_card;

    private Integer mobile_verify;

    public Integer getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(Integer bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card;
    }

    public Integer getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(Integer mobile_verify) {
        this.mobile_verify = mobile_verify;
    }
}
