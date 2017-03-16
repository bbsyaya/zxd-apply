package com.zhixindu.apply.facade.lender.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum MobileVerify implements IEnum<Integer> {
    UNVERIFIED(0, "未验证"), VERIFIED(1, "已验证");

    private int value;
    private String desc;

    MobileVerify(int value, String desc) {
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

    private static Map<Integer, MobileVerify> mappings = new HashMap<>();
    static {
        for (MobileVerify mobileVerify : MobileVerify.values()) {
            mappings.put(mobileVerify.getValue(), mobileVerify);
        }
    }

    public static MobileVerify resolve(Integer mobileVerify) {
        return mappings.get(mobileVerify);
    }
}
