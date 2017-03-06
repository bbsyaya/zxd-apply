package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.core.lender.po.BankCardPO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderBankCardMapper {

    int insertSelective(BankCardPO record);

    BankCardPO selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKeySelective(BankCardPO record);

    BankCardPO selectByLenderId(Integer lender_id);
}