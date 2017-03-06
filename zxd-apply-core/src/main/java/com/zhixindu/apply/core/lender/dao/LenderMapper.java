package com.zhixindu.apply.core.lender.dao;

import com.zhixindu.apply.core.lender.domain.Lender;

public interface LenderMapper {
    int deleteByPrimaryKey(Integer lender_id);

    int insertSelective(Lender record);

    Lender selectByPrimaryKey(Integer lender_id);

    int updateByPrimaryKeySelective(Lender record);

    Lender selectByCustomerId(String customer_id);

}