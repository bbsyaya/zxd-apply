package com.zhixindu.apply.core.lender.dao;

import com.zhixindu.apply.core.lender.domain.LenderContact;

public interface LenderContactMapper {
    int deleteByPrimaryKey(Integer contact_id);

    int insert(LenderContact record);

    int insertSelective(LenderContact record);

    LenderContact selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKeySelective(LenderContact record);

    int updateByPrimaryKey(LenderContact record);

    LenderContact selectByLenderId(Integer lender_id);
}