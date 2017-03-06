package com.zhixindu.apply.core.lender.domain;

import java.io.Serializable;

public class LenderBankCard implements Serializable {
    private Integer bank_card_id;

    private Integer lender_id;

    private String bank_card_number;

    private String bank_name;

    private Integer bank_address_code;

    private Integer bank_card_verify;

    private static final long serialVersionUID = 1L;

    public Integer getBank_card_id() {
        return bank_card_id;
    }

    public void setBank_card_id(Integer bank_card_id) {
        this.bank_card_id = bank_card_id;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number == null ? null : bank_card_number.trim();
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name == null ? null : bank_name.trim();
    }

    public Integer getBank_address_code() {
        return bank_address_code;
    }

    public void setBank_address_code(Integer bank_address_code) {
        this.bank_address_code = bank_address_code;
    }

    public Integer getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(Integer bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }
}