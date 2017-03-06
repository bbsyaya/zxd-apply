package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.AddressBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderAddressMapper {

    int insert(AddressBO record);

    int insertSelective(AddressBO record);

    AddressBO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(AddressBO record);

    int updateByPrimaryKeySelective(AddressBO record);

    AddressBO selectByLenderId(Integer lender_id);

    int countByLenderId(Integer lender_id);
}