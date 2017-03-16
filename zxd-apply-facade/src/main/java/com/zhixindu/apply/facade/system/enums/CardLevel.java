package com.zhixindu.apply.facade.system.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public enum CardLevel implements IEnum<Integer> {
    NORMAL(1, "普卡"), GOLD(2, "金卡"), PLATINUM(3, "白金卡");

    private int value;
    private String desc;

    CardLevel(int value, String desc) {
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

    private static Map<Integer, CardLevel> mappings = new HashMap<>();
    static {
        for (CardLevel cardLevel : CardLevel.values()) {
            mappings.put(cardLevel.getValue(), cardLevel);
        }
    }

    public static CardLevel resolve(Integer cardLevel) {
        return mappings.get(cardLevel);
    }
}
