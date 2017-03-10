package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderAddressMapper {

    int insert(LenderAddressBO record);

    int insertSelective(LenderAddressBO record);

    LenderAddressBO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(LenderAddressBO record);

    int updateByPrimaryKeySelective(LenderAddressBO record);

    LenderAddressBO selectByLenderId(Integer lender_id);

    int countByLenderId(Integer lender_id);
}