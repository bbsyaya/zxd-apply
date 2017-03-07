package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.RegionBO;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMapper {

    int insert(RegionBO record);

    int insertSelective(RegionBO record);

    RegionBO selectByPrimaryKey(Integer region_id);

    int updateByPrimaryKeySelective(RegionBO record);

    int updateByPrimaryKey(RegionBO record);
}