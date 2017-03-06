package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderBankCardMapper {

    int insert(BankCardBO record);

    int insertSelective(BankCardBO record);

    BankCardBO selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKey(BankCardBO record);

    int updateByPrimaryKeySelective(BankCardBO record);

    BankCardBO selectByLenderId(Integer lender_id);

    int countByLenderId(Integer lender_id);
}