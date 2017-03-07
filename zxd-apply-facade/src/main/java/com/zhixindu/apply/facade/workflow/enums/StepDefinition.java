package com.zhixindu.apply.facade.workflow.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public enum StepDefinition implements IEnum<Integer> {
    SUBMIT_APPLICATION(1, "提交申请"), REVIEW(2, "审核"), LOAN(3, "放款");

    private int value;
    private String desc;

    StepDefinition(int value, String desc) {
        this.value = value;
        this.desc = desc;
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

    private static Map<Integer, StepDefinition> mappings = new HashMap<>();
    static {
        for (StepDefinition stepDefinition : StepDefinition.values()) {
            mappings.put(stepDefinition.getValue(), stepDefinition);
        }
    }

    public static StepDefinition resolve(int stepDefinition) {
        return mappings.get(stepDefinition);
    }
}
