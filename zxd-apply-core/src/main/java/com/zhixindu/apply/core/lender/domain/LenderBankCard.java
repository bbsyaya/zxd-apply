package com.zhixindu.apply.core.lender.domain;

import java.io.Serializable;

public class LenderBankCard implements Serializable {
    private Integer bank_card_id;

    private Integer lender_id;

    private String bank_card_number;

    private String bank_name;

    private Short bank_code;

    private Byte bank_verfy;

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

    public Short getBank_code() {
        return bank_code;
    }

    public void setBank_code(Short bank_code) {
        this.bank_code = bank_code;
    }

    public Byte getBank_verfy() {
        return bank_verfy;
    }

    public void setBank_verfy(Byte bank_verfy) {
        this.bank_verfy = bank_verfy;
    }
}