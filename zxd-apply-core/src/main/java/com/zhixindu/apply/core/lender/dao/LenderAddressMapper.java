package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.core.lender.po.AddressPO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderAddressMapper {

    int insert(AddressPO record);

    AddressPO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(AddressPO record);

    AddressPO selectByLenderId(Integer lender_id);
}