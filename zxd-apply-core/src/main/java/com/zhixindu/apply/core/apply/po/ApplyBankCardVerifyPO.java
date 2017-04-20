package com.zhixindu.apply.core.apply.po;

import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyBankCardVerifyPO implements Serializable {
    private static final long serialVersionUID = -8829720976239552424L;

    /** 申请ID */
    private Integer apply_id;
    /** 银行卡验证 */
    private BankCardVerify bank_card_verify;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }


}
