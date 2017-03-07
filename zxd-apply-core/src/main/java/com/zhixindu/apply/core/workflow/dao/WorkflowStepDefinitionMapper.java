package com.zhixindu.apply.core.workflow.dao;

import com.zhixindu.apply.facade.workflow.bo.WorkflowStepDefinitionBO;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkflowStepDefinitionMapper {

    int insert(WorkflowStepDefinitionBO record);

    int insertSelective(WorkflowStepDefinitionBO record);

    WorkflowStepDefinitionBO selectByPrimaryKey(Integer step_definition_id);

    int updateByPrimaryKeySelective(WorkflowStepDefinitionBO record);

    int updateByPrimaryKey(WorkflowStepDefinitionBO record);
}