package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.BankCardVerify;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class LenderBankCardVerifyBO implements Serializable {
    private static final long serialVersionUID = -8829720976239552424L;

    /** 借款人ID */
    private Integer lender_id;
    /** 银行卡验证 */
    private BankCardVerify bank_card_verify;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }
}
