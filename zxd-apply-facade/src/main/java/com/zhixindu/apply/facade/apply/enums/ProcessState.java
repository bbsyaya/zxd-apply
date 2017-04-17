package com.zhixindu.apply.facade.apply.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum ProcessState implements IEnum<Integer> {
    FAIL(0, "失败"), SUCCESS(1, "成功"), PROCESSING(2, "中"), TIMEOUT(3, "超时");

    private int value;
    private String desc;

    ProcessState(int value, String desc) {
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

    private static Map<Integer, ProcessState> mappings = new HashMap<>();
    static {
        for (ProcessState processState : ProcessState.values()) {
            mappings.put(processState.getValue(), processState);
        }
    }

    public static ProcessState resolve(Integer processState) {
        return mappings.get(processState);
    }
}
