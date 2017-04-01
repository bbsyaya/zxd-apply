package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyCompleteStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStartStepBO;
import com.zhixindu.apply.core.apply.po.ApplyStepPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyStepMapper {

    int insert(ApplyStepPO record);

    int insertSelective(ApplyStepPO record);

    ApplyStepPO selectByPrimaryKey(Integer step_id);

    int updateByPrimaryKeySelective(ApplyStepPO record);

    int updateByPrimaryKey(ApplyStepPO record);

    int startStep(ApplyStartStepBO startStepBO);

    int completeStep(ApplyCompleteStepBO completeStepBO);

    List<ApplyStepPO> selectListByApplyId(Integer apply_id);

    ApplyStepPO selectLatestByApplyId(Integer apply_id);

    ApplyStepPO selectByApplyId(@Param("apply_id") Integer apply_id, @Param("process_step") Integer process_step);

}