package com.zhixindu.apply.facade.apply.enums;

import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/16.
 */
public enum TermUnit implements IEnum<Integer> {
    DAILY(1, "日"), MONTHLY(2, "月");

    private int value;
    private String desc;

    TermUnit(int value, String desc) {
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

    private static Map<Integer, TermUnit> mappings = new HashMap<>();
    static {
        for (TermUnit termUnit : TermUnit.values()) {
            mappings.put(termUnit.getValue(), termUnit);
        }
    }

    public static TermUnit resolve(Integer termUnit) {
        return mappings.get(termUnit);
    }

}
