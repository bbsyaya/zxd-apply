package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.applicant.enums.ApplyResult;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SteveGuo on 2017/4/12.
 */
public class ApplyResultBO implements Serializable {
    private static final long serialVersionUID = -3971763643006379478L;

    /** 申請人ID */
    @NotNull(message = "申請人ID不能爲空")
    private Integer applicant_id;
    /** 申請結果 */
    @NotNull(message = "申請結果不能爲空")
    private ApplyResult apply_result;
    /** 拒絕時間 */
    @NotNull(message = "拒絕時間不能爲空")
    private Date reject_time;

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public ApplyResult getApply_result() {
        return apply_result;
    }

    public void setApply_result(ApplyResult apply_result) {
        this.apply_result = apply_result;
    }

    public Date getReject_time() {
        return reject_time;
    }

    public void setReject_time(Date reject_time) {
        this.reject_time = reject_time;
    }
}
