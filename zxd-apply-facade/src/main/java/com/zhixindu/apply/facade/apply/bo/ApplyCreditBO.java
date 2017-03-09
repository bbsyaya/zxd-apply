package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ApplyStatus;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public class ApplyCreditBO implements Serializable{

    private static final long serialVersionUID = -6877810588246495772L;

    /** 申请状态 */
    private ApplyStatus apply_status;
    /** 信用代码 */
    private String credit_code;
    /** 信用评分 */
    private Integer credit_score;
    /** 信用备忘录 */
    private String credit_memo;

    public ApplyStatus getApply_status() {
        return apply_status;
    }

    public void setApply_status(ApplyStatus apply_status) {
        this.apply_status = apply_status;
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
}
