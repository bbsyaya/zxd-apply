package com.zhixindu.apply.core.loan.dao;

import com.zhixindu.apply.core.loan.domain.LoanWorkflowStepDefinition;

public interface LoanWorkflowStepDefinitionMapper {
    int deleteByPrimaryKey(Integer step_definition_id);

    int insert(LoanWorkflowStepDefinition record);

    int insertSelective(LoanWorkflowStepDefinition record);

    LoanWorkflowStepDefinition selectByPrimaryKey(Integer step_definition_id);

    int updateByPrimaryKeySelective(LoanWorkflowStepDefinition record);

    int updateByPrimaryKey(LoanWorkflowStepDefinition record);
}