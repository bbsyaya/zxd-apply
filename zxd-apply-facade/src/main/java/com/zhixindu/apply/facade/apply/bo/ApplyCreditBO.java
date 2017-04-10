package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public class ApplyCreditBO implements Serializable{

    private static final long serialVersionUID = -6877810588246495772L;
    /** 申请借款ID */
    private Integer apply_id;
    /** 申请人ID */
    private Integer applicant_id;
    /** 申请状态 */
    private ApplyStatus apply_status;
    /** 审核时间 */
    private Date review_time;
    /** 信用代码 */
    private String credit_code;
    /** 信用评分 */
    private Integer credit_score;
    /** 信用备忘录 */
    private String credit_memo;
    /** 银行卡认证状态 */
    private BankCardVerify bank_card_verify;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
    }

    public Date getReview_time() {
        return review_time;
    }

    public void setReview_time(Date review_time) {
        this.review_time = review_time;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public String getCredit_memo() {
        return credit_memo;
    }

    public void setCredit_memo(String credit_memo) {
        this.credit_memo = credit_memo;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }
}
