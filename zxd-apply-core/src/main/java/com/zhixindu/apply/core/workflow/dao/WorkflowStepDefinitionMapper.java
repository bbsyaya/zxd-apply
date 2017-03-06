package com.zhixindu.apply.core.workflow.dao;

import com.zhixindu.apply.core.workflow.domain.WorkflowStepDefinition;

public interface WorkflowStepDefinitionMapper {
    int deleteByPrimaryKey(Integer step_definition_id);

    int insert(WorkflowStepDefinition record);

    int insertSelective(WorkflowStepDefinition record);

    WorkflowStepDefinition selectByPrimaryKey(Integer step_definition_id);

    int updateByPrimaryKeySelective(WorkflowStepDefinition record);

    int updateByPrimaryKey(WorkflowStepDefinition record);
}