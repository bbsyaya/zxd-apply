package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import com.zhixindu.apply.facade.apply.bo.WorkflowStepInstanceBO;

import java.util.List;

public interface ApplyStepMapper {

    int insert(ApplyStepBO record);

    int insertSelective(ApplyStepBO record);

    ApplyStepBO selectByPrimaryKey(Integer step_id);

    int updateByPrimaryKeySelective(ApplyStepBO record);

    int updateByPrimaryKey(ApplyStepBO record);

    List<WorkflowStepInstanceBO> selectListByApplyId(Integer apply_id);
}