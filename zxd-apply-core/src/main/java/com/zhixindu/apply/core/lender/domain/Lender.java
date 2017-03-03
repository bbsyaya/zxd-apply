package com.zhixindu.apply.core.lender.domain;

import java.io.Serializable;

public class Lender implements Serializable {
    private Integer lender_id;

    private String customer_id;

    private String mobile;

    private String service_password;

    private String name;

    private String id_card;

    private Byte mobile_verify;

    private Byte bank_card_verify;

    private String credit_situation;

    private static final long serialVersionUID = 1L;

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
        this.customer_id = customer_id == null ? null : customer_id.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getService_password() {
        return service_password;
    }

    public void setService_password(String service_password) {
        this.service_password = service_password == null ? null : service_password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    public Byte getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(Byte mobile_verify) {
        this.mobile_verify = mobile_verify;
    }

    public Byte getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(Byte bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public String getCredit_situation() {
        return credit_situation;
    }

    public void setCredit_situation(String credit_situation) {
        this.credit_situation = credit_situation == null ? null : credit_situation.trim();
    }
}