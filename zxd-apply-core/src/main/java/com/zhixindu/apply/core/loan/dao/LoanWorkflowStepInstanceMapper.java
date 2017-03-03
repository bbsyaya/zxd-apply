package com.zhixindu.apply.core.loan.dao;

import com.zhixindu.apply.core.loan.domain.LoanWorkflowStepInstance;

public interface LoanWorkflowStepInstanceMapper {
    int deleteByPrimaryKey(Integer step_instance_id);

    int insert(LoanWorkflowStepInstance record);

    int insertSelective(LoanWorkflowStepInstance record);

    LoanWorkflowStepInstance selectByPrimaryKey(Integer step_instance_id);

    int updateByPrimaryKeySelective(LoanWorkflowStepInstance record);

    int updateByPrimaryKey(LoanWorkflowStepInstance record);
}