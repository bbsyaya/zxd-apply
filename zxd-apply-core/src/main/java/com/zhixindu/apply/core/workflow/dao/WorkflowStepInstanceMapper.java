package com.zhixindu.apply.core.workflow.dao;

import com.zhixindu.apply.core.workflow.domain.WorkflowStepInstance;

public interface WorkflowStepInstanceMapper {
    int deleteByPrimaryKey(Integer step_instance_id);

    int insert(WorkflowStepInstance record);

    int insertSelective(WorkflowStepInstance record);

    WorkflowStepInstance selectByPrimaryKey(Integer step_instance_id);

    int updateByPrimaryKeySelective(WorkflowStepInstance record);

    int updateByPrimaryKey(WorkflowStepInstance record);
}