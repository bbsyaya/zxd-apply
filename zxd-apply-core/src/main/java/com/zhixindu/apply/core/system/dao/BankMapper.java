package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.BankBO;

public interface BankMapper {
    int deleteByPrimaryKey(Integer bank_id);

    int insert(BankBO record);

    int insertSelective(BankBO record);

    BankBO selectByPrimaryKey(Integer bank_id);

    int updateByPrimaryKeySelective(BankBO record);

    int updateByPrimaryKey(BankBO record);
}