package com.zhixindu.apply.facade.workflow.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum ProcessingState implements IEnum<Integer> {
    FAIL(0, "失败"), SUCCESS(1, "成功"), PROCESSING(2, "中");

    private int value;
    private String desc;

    ProcessingState(int value, String desc) {
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

    private static Map<Integer, ProcessingState> mappings = new HashMap<>();
    static {
        for (ProcessingState processingState : ProcessingState.values()) {
            mappings.put(processingState.getValue(), processingState);
        }
    }

    public static ProcessingState resolve(int stepState) {
        return mappings.get(stepState);
    }
}
