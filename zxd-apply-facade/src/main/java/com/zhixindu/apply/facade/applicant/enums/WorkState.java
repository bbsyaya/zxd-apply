package com.zhixindu.apply.facade.applicant.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public enum WorkState implements IEnum<Integer> {
    UNEMPLOYED(0, "待业"), EMPLOYEE(1, "在职"), STUDENT(2, "学生");

    private int value;
    private String desc;

    WorkState(int value, String desc) {
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

    private static Map<Integer, WorkState> mappings = new HashMap<>();
    static {
        for (WorkState workState : WorkState.values()) {
            mappings.put(workState.getValue(), workState);
        }
    }

    public static WorkState resolve(Integer workState) {
        return mappings.get(workState);
    }
}
