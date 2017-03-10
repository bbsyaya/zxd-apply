package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.ApplyResult;
import com.zhixindu.apply.facade.lender.enums.FillStep;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyResultBO implements Serializable {
    private static final long serialVersionUID = 7056702222939579270L;

    /** 借款人ID */
    private Integer lender_id;
    /** 拒绝时间 */
    private Date reject_time;
    /** 填写步骤 */
    private FillStep fill_step;
    /** 申请结果 */
    private ApplyResult apply_result;
    /** 信用评分 */
    private Integer credit_score;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public Date getReject_time() {
        return reject_time;
    }

    public void setReject_time(Date reject_time) {
        this.reject_time = reject_time;
    }

    public FillStep getFill_step() {
        return fill_step;
    }

    public void setFill_step(FillStep fill_step) {
        this.fill_step = fill_step;
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
}
