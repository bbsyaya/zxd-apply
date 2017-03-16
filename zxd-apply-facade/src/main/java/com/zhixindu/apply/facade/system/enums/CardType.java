package com.zhixindu.apply.facade.system.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public enum CardType implements IEnum<Integer> {
    CREDIT(1, "贷记卡"), DEBIT(2, "借记卡");

    private int value;
    private String desc;

    CardType(int value, String desc) {
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

    private static Map<Integer, CardType> mappings = new HashMap<>();
    static {
        for (CardType cardType : CardType.values()) {
            mappings.put(cardType.getValue(), cardType);
        }
    }

    public static CardType resolve(Integer cardType) {
        return mappings.get(cardType);
    }
}
