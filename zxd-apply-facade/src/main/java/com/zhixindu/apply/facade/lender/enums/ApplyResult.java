package com.zhixindu.apply.facade.lender.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum ApplyResult implements IEnum<Integer> {
    REJECT(0, "被拒绝"), APPROVE(1, "已通过");

    private int value;
    private String desc;

    ApplyResult(int value, String desc) {
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

    private static Map<Integer, ApplyResult> mappings = new HashMap<>();
    static {
        for (ApplyResult applyResult : ApplyResult.values()) {
            mappings.put(applyResult.getValue(), applyResult);
        }
    }

    public static ApplyResult resolve(int applyResult) {
        return mappings.get(applyResult);
    }
}
