package com.zhixindu.apply.facade.apply.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public enum ProcessStep implements IEnum<Integer> {
    SUBMIT_APPLICATION(1, "提交申请"), REVIEW(2, "审核"), LOAN(3, "放款");

    private int value;
    private String desc;

    ProcessStep(int value, String desc) {
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

    private static Map<Integer, ProcessStep> mappings = new HashMap<>();
    static {
        for (ProcessStep processStep : ProcessStep.values()) {
            mappings.put(processStep.getValue(), processStep);
        }
    }

    public static ProcessStep resolve(Integer processStep) {
        return mappings.get(processStep);
    }

}
