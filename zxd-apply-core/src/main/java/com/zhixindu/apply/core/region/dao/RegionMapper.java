package com.zhixindu.apply.core.region.dao;

import com.zhixindu.apply.core.region.domain.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(Integer region_id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer region_id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}