package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.BankBO;
import org.springframework.stereotype.Repository;

@Repository
public interface BankMapper {

    int insert(BankBO record);

    int insertSelective(BankBO record);

    BankBO selectByPrimaryKey(Integer bank_id);

    int updateByPrimaryKeySelective(BankBO record);

    int updateByPrimaryKey(BankBO record);

    String selectBankNameByBankCardNumber(Integer bankCardNumber);
}