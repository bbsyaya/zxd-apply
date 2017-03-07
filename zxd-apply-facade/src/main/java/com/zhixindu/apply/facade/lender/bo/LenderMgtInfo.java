/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class LenderMgtInfo implements Serializable {

    private static final long serialVersionUID = -8507298900725978088L;

    /**
     * 借款ID
     */
    private Integer lender_id;
    /**
     * 借款人ID
     */
    private String customer_id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String id_card;
    /**
     * 手机号认证信息（0未验证，1已验证）
     */
    private Integer mobile_verify;
    /**
     * 银行卡认证信息（0未验证，1已验证）
     */
    private Integer bank_card_verify;
    /**
     * 地址
     */
    private AddressBO addressBO;
    /**
     * 联系人
     */
    private List<ContactBO> contactBOs;
    /**
     * 银行卡
     */
    private BankCardBO bankCardBO;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Integer getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(Integer mobile_verify) {
        this.mobile_verify = mobile_verify;
    }

    public Integer getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(Integer bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public AddressBO getAddressBO() {
        return addressBO;
    }

    public void setAddressBO(AddressBO addressBO) {
        this.addressBO = addressBO;
    }

    public List<ContactBO> getContactBOs() {
        return contactBOs;
    }

    public void setContactBOs(List<ContactBO> contactBOs) {
        this.contactBOs = contactBOs;
    }

    public BankCardBO getBankCardBO() {
        return bankCardBO;
    }

    public void setBankCardBO(BankCardBO bankCardBO) {
        this.bankCardBO = bankCardBO;
    }
}
