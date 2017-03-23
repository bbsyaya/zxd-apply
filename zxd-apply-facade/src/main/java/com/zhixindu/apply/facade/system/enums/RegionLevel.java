package com.zhixindu.apply.facade.system.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public enum RegionLevel implements IEnum<Integer> {
    PROVINCE(1, "省"), CITY(2, "市"), COUNTY(3, "区/县");

    private int value;
    private String desc;

    RegionLevel(int value, String desc) {
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

    private static Map<Integer, RegionLevel> mappings = new HashMap<>();
    static {
        for (RegionLevel cardLevel : RegionLevel.values()) {
            mappings.put(cardLevel.getValue(), cardLevel);
        }
    }

    public static RegionLevel resolve(Integer cardLevel) {
        return mappings.get(cardLevel);
    }
}
