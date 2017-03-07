package com.zhixindu.apply.core.workflow.dao;

import com.zhixindu.apply.facade.workflow.bo.WorkflowStepInstanceBO;

public interface WorkflowStepInstanceMapper {

    int insert(WorkflowStepInstanceBO record);

    int insertSelective(WorkflowStepInstanceBO record);

    WorkflowStepInstanceBO selectByPrimaryKey(Integer step_instance_id);

    int updateByPrimaryKeySelective(WorkflowStepInstanceBO record);

    int updateByPrimaryKey(WorkflowStepInstanceBO record);
}