/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.enums;

import com.google.common.collect.ImmutableMap;
import com.zhixindu.apply.facade.workflow.enums.StepDefinition;
import com.zhixindu.apply.facade.workflow.enums.StepState;
import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/7
 * @description
 */
public enum ApplyStatus implements IEnum<Integer>{

    UNDER_REVIEW(1, "审核中", ImmutableMap.of(StepDefinition.REVIEW, StepState.PROCESSING)),
    REVIEW_SUCCESS(2, "审核成功", ImmutableMap.of(StepDefinition.REVIEW, StepState.SUCCESS)),
    REVIEW_FAIL(3, "审核失败", ImmutableMap.of(StepDefinition.REVIEW, StepState.FAIL)),
    LOAN_SUCCESS(4, "放款成功", ImmutableMap.of(StepDefinition.LOAN, StepState.SUCCESS)),
    LOAN_FAIL(5, "放款失败", ImmutableMap.of(StepDefinition.LOAN, StepState.FAIL));

    private int value;
    private String desc;
    private Map<StepDefinition, StepState> definitionStateMapping;

    ApplyStatus(int value, String desc, Map<StepDefinition, StepState> definitionStateMapping) {
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

    public static ApplyStatus resolve(int applyStatus) {
        return mappings.get(applyStatus);
    }

    public StepDefinition getStepDefinition(){
        return definitionStateMapping.keySet().iterator().next();
    }

    public StepState getStepState(){
        return definitionStateMapping.values().iterator().next();
    }
}
