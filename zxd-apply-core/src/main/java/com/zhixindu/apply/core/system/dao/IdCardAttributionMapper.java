package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.IdCardAttributionBO;

import java.util.List;

public interface IdCardAttributionMapper {

    int insert(IdCardAttributionBO record);

    int insertSelective(IdCardAttributionBO record);

    IdCardAttributionBO selectByPrimaryKey(Integer attribution_id);

    int updateByPrimaryKeySelective(IdCardAttributionBO record);

    int updateByPrimaryKey(IdCardAttributionBO record);

    List<IdCardAttributionBO> selectAll();
}