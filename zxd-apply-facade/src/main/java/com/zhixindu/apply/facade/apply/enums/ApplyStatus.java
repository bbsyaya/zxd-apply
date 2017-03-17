/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.enums;

import com.google.common.collect.ImmutableMap;
import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SteveGuo
 * @version 1.0
 * @date 2017/3/7
 * @description
 */
public enum ApplyStatus implements IEnum<Integer> {

    UNDER_REVIEW(1, "审核中", ImmutableMap.of(ProcessStep.REVIEW, ProcessState.PROCESSING)),
    REVIEW_SUCCESS(2, "审核成功", ImmutableMap.of(ProcessStep.REVIEW, ProcessState.SUCCESS)),
    REVIEW_FAIL(3, "审核失败", ImmutableMap.of(ProcessStep.REVIEW, ProcessState.FAIL)),
    UNDER_LOAN(4, "放款中", ImmutableMap.of(ProcessStep.LOAN, ProcessState.PROCESSING)),
    LOAN_SUCCESS(5, "放款成功", ImmutableMap.of(ProcessStep.LOAN, ProcessState.SUCCESS)),
    LOAN_FAIL(6, "放款失败", ImmutableMap.of(ProcessStep.LOAN, ProcessState.FAIL)),
    REPAYMENT_SETTLED(7, "已结清", null);

    private int value;
    private String desc;
    private Map<ProcessStep, ProcessState> definitionStateMapping;

    ApplyStatus(int value, String desc, Map<ProcessStep, ProcessState> definitionStateMapping) {
        this.value = value;
        this.desc = desc;
        this.definitionStateMapping = definitionStateMapping;
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

    static {
        for (ApplyStatus applyStatus : ApplyStatus.values()) {
            mappings.put(applyStatus.getValue(), applyStatus);
        }
    }

    public static ApplyStatus resolve(Integer applyStatus) {
        return mappings.get(applyStatus);
    }

    public ProcessStep getStepDefinition(){
        return definitionStateMapping.keySet().iterator().next();
    }

    public ProcessState getStepState(){
        return definitionStateMapping.values().iterator().next();
    }
}
