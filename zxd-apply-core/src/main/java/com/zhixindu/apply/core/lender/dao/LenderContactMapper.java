package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.core.lender.po.ContactPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenderContactMapper {

    int deleteByPrimaryKey(Integer contact_id);

    int insert(ContactPO record);

    ContactPO selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKey(ContactPO record);

    List<ContactPO> selectByLenderId(Integer lender_id);

}