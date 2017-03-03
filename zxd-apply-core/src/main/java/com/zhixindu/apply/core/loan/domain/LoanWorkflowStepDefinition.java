package com.zhixindu.apply.core.loan.domain;

import java.io.Serializable;

public class LoanWorkflowStepDefinition implements Serializable {
    private Integer step_definition_id;

    private String step_name;

    private static final long serialVersionUID = 1L;

    public Integer getStep_definition_id() {
        return step_definition_id;
    }

    public void setStep_definition_id(Integer step_definition_id) {
        this.step_definition_id = step_definition_id;
    }

    public String getStep_name() {
        return step_name;
    }

    public void setStep_name(String step_name) {
        this.step_name = step_name == null ? null : step_name.trim();
    }
}