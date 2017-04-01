package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.core.apply.po.ApplyLocationPO;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyLocationMapper {

    int insert(ApplyLocationPO record);

    int insertSelective(ApplyLocationPO record);

    ApplyLocationPO selectByPrimaryKey(Integer location_id);

    int updateByPrimaryKeySelective(ApplyLocationPO record);

    int updateByPrimaryKey(ApplyLocationPO record);

    ApplyLocationPO selectByApplyId(Integer apply_id);

}