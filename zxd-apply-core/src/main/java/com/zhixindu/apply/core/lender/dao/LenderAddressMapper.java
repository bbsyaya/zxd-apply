package com.zhixindu.apply.core.lender.dao;

import com.zhixindu.apply.core.lender.domain.LenderAddress;

public interface LenderAddressMapper {
    int deleteByPrimaryKey(Integer address_id);

    int insert(LenderAddress record);

    int insertSelective(LenderAddress record);

    LenderAddress selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKeySelective(LenderAddress record);

    int updateByPrimaryKey(LenderAddress record);
}