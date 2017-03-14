package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyLocationBO;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyLocationMapper {

    int insert(ApplyLocationBO record);

    int insertSelective(ApplyLocationBO record);

    ApplyLocationBO selectByPrimaryKey(Integer location_id);

    int updateByPrimaryKeySelective(ApplyLocationBO record);

    int updateByPrimaryKey(ApplyLocationBO record);

    ApplyLocationBO selectByApplyId(Integer apply_id);

}