package com.zhixindu.apply.facade.system.bo;

import com.zhixindu.apply.facade.system.enums.CardLevel;
import com.zhixindu.apply.facade.system.enums.CardType;

import java.io.Serializable;

public class BankBO extends BankBaseBO implements Serializable {

    private static final long serialVersionUID = -8252653732160180148L;
    /** 银行ID */
    private Integer bank_id;
    /** BIN长度 */
    private Integer bin_length;
    /** 银行卡类型（1贷记卡，2借记卡） */
    private CardType card_type;
    /** 银行卡级别（1普卡，2金卡，3白金卡） */
    private CardLevel card_level;
    /** 银行卡名称 */
    private String card_name;
    /** 银行卡全名 */
    private String card_full_name;

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public Integer getBin_length() {
        return bin_length;
    }

    public void setBin_length(Integer bin_length) {
        this.bin_length = bin_length;
    }

    public CardType getCard_type() {
        return card_type;
    }

    public void setCard_type(CardType card_type) {
        this.card_type = card_type;
    }

    public CardLevel getCard_level() {
        return card_level;
    }

    public void setCard_level(CardLevel card_level) {
        this.card_level = card_level;
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