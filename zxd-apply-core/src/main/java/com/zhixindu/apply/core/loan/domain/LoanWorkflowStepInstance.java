package com.zhixindu.apply.core.loan.domain;

import java.io.Serializable;
import java.util.Date;

public class LoanWorkflowStepInstance implements Serializable {
    private Integer step_instance_id;

    private Integer loan_id;

    private Integer step_definition_id;

    private Date processing_time;

    private Integer processing_state;

    private static final long serialVersionUID = 1L;

    public Integer getStep_instance_id() {
        return step_instance_id;
    }

    public void setStep_instance_id(Integer step_instance_id) {
        this.step_instance_id = step_instance_id;
    }

    public Integer getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Integer loan_id) {
        this.loan_id = loan_id;
    }

    public Integer getStep_definition_id() {
        return step_definition_id;
    }

    public void setStep_definition_id(Integer step_definition_id) {
        this.step_definition_id = step_definition_id;
    }

    public Date getProcessing_time() {
        return processing_time;
    }

    public void setProcessing_time(Date processing_time) {
        this.processing_time = processing_time;
    }

    public Integer getProcessing_state() {
        return processing_state;
    }

    public void setProcessing_state(Integer processing_state) {
        this.processing_state = processing_state;
    }
}