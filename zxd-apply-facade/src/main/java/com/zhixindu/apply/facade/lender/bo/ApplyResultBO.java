package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.ApplyResult;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyResultBO implements Serializable {
    private static final long serialVersionUID = 7056702222939579270L;

    /** 申请结果 */
    private ApplyResult apply_result;
    /** 信用评分 */
    private Integer credit_score;

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
}
