package com.zhixindu.apply.core.apply.po;

import com.zhixindu.apply.facade.applicant.enums.ApplyResult;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyResultPO implements Serializable {
    private static final long serialVersionUID = 7056702222939579270L;

    /** 申请人ID */
    private Integer applicant_id;
    /** 拒绝时间 */
    private Date reject_time;
    /** 申请结果 */
    private ApplyResult apply_result;
    /** 信用评分 */
    private Integer credit_score;
    /** 银行卡认证结果 */
    private BankCardVerify bank_card_verify;
    /** 填写步骤 */
    private LoanFillStep loan_fill_step;

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public Date getReject_time() {
        return reject_time;
    }

    public void setReject_time(Date reject_time) {
        this.reject_time = reject_time;
    }

    public ApplyResult getApply_result() {
        return apply_result;
    }

    public void setApply_result(ApplyResult apply_result) {
        this.apply_result = apply_result;
    }

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
