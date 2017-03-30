/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.enums;

import com.zhixindu.apply.facade.applicant.enums.ApplyResult;
import com.zhixindu.commons.api.IEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SteveGuo
 * @version 1.0
 * @date 2017/3/7
 * @description
 */
public enum ApplyStatus implements IEnum<Integer> {

    PREPARE_SUBMIT(-1, "申请中", ApplyResult.APPROVE, ProcessStep.SUBMIT, ProcessState.PROCESSING),
    SUBMIT_SUCCESS(0, "提交申请", ApplyResult.APPROVE, ProcessStep.SUBMIT, ProcessState.SUCCESS),
    UNDER_REVIEW(1, "审核中", null, ProcessStep.REVIEW, ProcessState.PROCESSING),
    REVIEW_SUCCESS(2, "审核成功", ApplyResult.APPROVE, ProcessStep.REVIEW, ProcessState.SUCCESS),
    REVIEW_FAIL(3, "审核失败", ApplyResult.REJECT, ProcessStep.REVIEW, ProcessState.FAIL),
    UNDER_LOAN(4, "放款中", null, ProcessStep.LOAN, ProcessState.PROCESSING),
    LOAN_SUCCESS(5, "放款成功", ApplyResult.APPROVE, ProcessStep.LOAN, ProcessState.SUCCESS),
    LOAN_FAIL(6, "放款失败", ApplyResult.REJECT, ProcessStep.LOAN, ProcessState.FAIL),
    UNDER_REPAYMENT(7, "待还款", null, ProcessStep.REPAYMENT, ProcessState.PROCESSING),
    REPAYMENT_SETTLED(8, "已结清", ApplyResult.APPROVE, ProcessStep.REPAYMENT, ProcessState.SUCCESS);

    private int value;
    private String desc;
    private ApplyResult applyResult;
    private ProcessStep processStep;
    private ProcessState processState;

    ApplyStatus(int value, String desc, ApplyResult applyResult, ProcessStep processStep, ProcessState processState) {
        this.value = value;
        this.desc = desc;
        this.applyResult = applyResult;
        this.processStep = processStep;
        this.processState = processState;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public boolean matches(Integer value) {
        if(null == value) {
            return false;
        }
        return getValue().intValue() == value.intValue();
    }

    @Override
    public boolean matches(IEnum<Integer> valueBean) {
        if(null == valueBean) {
            return false;
        }
        return matches(valueBean.getValue());
    }

    private static Map<Integer, ApplyStatus> mappings = new HashMap<>();
    private static Map<String, ApplyStatus> processStepStatusApplyStatusMappings = new HashMap<>();

    static {
        Arrays.stream(ApplyStatus.values())
                .forEach(applyStatus -> {
                    mappings.put(applyStatus.getValue(), applyStatus);
                    String key = applyStatus.getProcessStep().name() + applyStatus.getProcessState().name();
                    processStepStatusApplyStatusMappings.put(key, applyStatus);
                });
    }

    public static ApplyStatus resolve(Integer applyStatus) {
        return mappings.get(applyStatus);
    }

    public static ApplyStatus resolve(ProcessStep processStep, ProcessState processState){
        String key = processStep.name() + processState.name();
        return processStepStatusApplyStatusMappings.get(key);
    }

    public ApplyResult getApplyResult() {
        return applyResult;
    }

    public ProcessStep getProcessStep(){
        return processStep;
    }

    public ProcessState getProcessState(){
        return processState;
    }

    public static void main(String[] args) {
        System.out.println(ApplyStatus.resolve(ProcessStep.REPAYMENT, ProcessState.PROCESSING).getDesc());
    }

}
