package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.core.system.domain.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(Integer region_id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer region_id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}