package com.zhixindu.apply.core.applicant.po;

import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyResultPO extends ApplyResultBO implements Serializable {
    private static final long serialVersionUID = 7056702222939579270L;

    /** 信用评分 */
    private Integer credit_score;
    /** 银行卡认证结果 */
    private BankCardVerify bank_card_verify;
    /** 填写步骤 */
    private LoanFillStep loan_fill_step;

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public LoanFillStep getLoan_fill_step() {
        return loan_fill_step;
    }

    public void setLoan_fill_step(LoanFillStep loan_fill_step) {
        this.loan_fill_step = loan_fill_step;
    }
}
