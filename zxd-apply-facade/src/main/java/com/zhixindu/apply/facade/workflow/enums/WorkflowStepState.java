package com.zhixindu.apply.facade.workflow.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public enum WorkflowStepState implements IEnum<Integer> {
    FAIL(0, "失败"), SUCCESS(1, "成功"), PROCESSING(2, "中");

    private int value;
    private String desc;

    WorkflowStepState(int value, String desc) {
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

    private static Map<Integer, WorkflowStepState> mappings = new HashMap<>();
    static {
        for (WorkflowStepState workflowStepState : WorkflowStepState.values()) {
            mappings.put(workflowStepState.getValue(), workflowStepState);
        }
    }

    public static WorkflowStepState resolve(int workflowStepState) {
        return mappings.get(workflowStepState);
    }
}
