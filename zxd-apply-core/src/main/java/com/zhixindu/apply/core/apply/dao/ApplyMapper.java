package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer apply_id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}