package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.core.system.domain.Bank;

public interface BankMapper {
    int deleteByPrimaryKey(Integer bank_id);

    int insert(Bank record);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer bank_id);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
}