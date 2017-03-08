package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.RegionBO;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionMapper {

    int insert(RegionBO record);

    int insertSelective(RegionBO record);

    RegionBO selectByPrimaryKey(Integer region_id);

    int updateByPrimaryKeySelective(RegionBO record);

    int updateByPrimaryKey(RegionBO record);

    List<RegionBaseBO> selectAll();

    List<RegionBaseBO> selectListByParentCode(Integer parent_code);

    RegionBaseBO selectByCode(Integer code);
}