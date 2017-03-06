package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.ContactBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenderContactMapper {

    int insert(ContactBO record);

    int insertSelective(ContactBO record);

    ContactBO selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKey(ContactBO record);

    int updateByPrimaryKeySelective(ContactBO record);

    List<ContactBO> selectByLenderId(Integer lender_id);

    int countByLenderId(Integer lender_id);

}