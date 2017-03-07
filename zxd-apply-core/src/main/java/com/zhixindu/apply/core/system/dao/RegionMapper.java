package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.RegionBO;

public interface RegionMapper {
    int deleteByPrimaryKey(Integer region_id);

    int insert(RegionBO record);

    int insertSelective(RegionBO record);

    RegionBO selectByPrimaryKey(Integer region_id);

    int updateByPrimaryKeySelective(RegionBO record);

    int updateByPrimaryKey(RegionBO record);
}