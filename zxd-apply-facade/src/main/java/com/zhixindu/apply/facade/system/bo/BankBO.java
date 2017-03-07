package com.zhixindu.apply.facade.system.bo;

import java.io.Serializable;

public class BankBO implements Serializable {
    private Integer bank_id;

    private Integer bin;

    private Integer bin_length;

    private Integer card_type;

    private Integer card_level;

    private String bank_name;

    private String card_name;

    private String card_full_name;

    private static final long serialVersionUID = 1L;

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public Integer getBin_length() {
        return bin_length;
    }

    public void setBin_length(Integer bin_length) {
        this.bin_length = bin_length;
    }

    public Integer getCard_type() {
        return card_type;
    }

    public void setCard_type(Integer card_type) {
        this.card_type = card_type;
    }

    public Integer getCard_level() {
        return card_level;
    }

    public void setCard_level(Integer card_level) {
        this.card_level = card_level;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name == null ? null : bank_name.trim();
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name == null ? null : card_name.trim();
    }

    public String getCard_full_name() {
        return card_full_name;
    }

    public void setCard_full_name(String card_full_name) {
        this.card_full_name = card_full_name == null ? null : card_full_name.trim();
    }
}