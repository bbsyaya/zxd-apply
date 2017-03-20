package com.zhixindu.apply.facade.apply.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public enum ProcessStep implements IEnum<Integer> {
    SUBMIT(1, "提交申请", ""), REVIEW(2, "审核", "审核时间最多5分钟"),
    LOAN(3, "放款", "工作日最快2小时"), REPAYMENT(4, "还款", "");

    private int value;
    private String desc;
    private String processDesc;

    ProcessStep(int value, String desc, String processDesc) {
        this.value = value;
        this.desc = desc;
        this.processDesc = processDesc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public String getProcessDesc() {
        return processDesc;
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
