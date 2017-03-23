package com.zhixindu.apply.facade.lender.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum ContactRelationship implements IEnum<Integer> {

    PARENT(1, "父母"), SPOUSE(2, "配偶"), CHILD(3, "子女"), FRIEND(4, "朋友");

    private int value;
    private String desc;

    ContactRelationship(int value, String desc) {
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

    private static Map<Integer, ContactRelationship> mappings = new HashMap<>();
    static {
        for (ContactRelationship contactRelationship : ContactRelationship.values()) {
            mappings.put(contactRelationship.getValue(), contactRelationship);
        }
    }

    public static ContactRelationship resolve(Integer contactRelationship) {
        return mappings.get(contactRelationship);
    }

}
