package com.zhixindu.apply.core.applicant.po;

import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyResultPO extends ApplyResultBO implements Serializable {
    private static final long serialVersionUID = 7056702222939579270L;

    /** 信用评分 */
    private Integer credit_score;

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

}
