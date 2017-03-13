package com.zhixindu.apply.facade.apply.enums;

import com.google.common.collect.ImmutableMap;
import com.zhixindu.apply.facade.lender.enums.ApplyResult;

import java.util.Map;

/**
 * 申请结果与申请状态的映射
 * Created by SteveGuo on 2017/3/13.
 */
public enum ApplyResultStatusMapping {
    ;
    private static Map<ApplyStatus, ApplyResult> mappings = ImmutableMap.of(
            ApplyStatus.REVIEW_SUCCESS, ApplyResult.APPROVE,
            ApplyStatus.REVIEW_FAIL, ApplyResult.REJECT,
            ApplyStatus.LOAN_SUCCESS, ApplyResult.APPROVE,
            ApplyStatus.LOAN_FAIL, ApplyResult.REJECT);

    public static ApplyResult getApplyResult(ApplyStatus applyStatus) {
        return mappings.get(applyStatus);
    }

}
