package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;

import java.util.List;

public interface ApplyStepMapper {

    int insert(ApplyStepBO record);

    int insertSelective(ApplyStepBO record);

    ApplyStepBO selectByPrimaryKey(Integer step_id);

    int updateByPrimaryKeySelective(ApplyStepBO record);

    int updateByPrimaryKey(ApplyStepBO record);

    List<ApplyStepBO> selectListByApplyId(Integer apply_id);

    ApplyStepBO selectLatestByApplyId(Integer apply_id);
}