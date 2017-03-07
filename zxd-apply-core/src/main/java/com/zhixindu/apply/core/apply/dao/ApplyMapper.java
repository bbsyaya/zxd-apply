package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer apply_id);

    int insert(ApplyBO record);

    int insertSelective(ApplyBO record);

    ApplyBO selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(ApplyBO record);

    int updateByPrimaryKey(ApplyBO record);
}