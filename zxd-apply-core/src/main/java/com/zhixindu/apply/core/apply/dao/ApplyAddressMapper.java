package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.core.apply.po.ApplyAddressPO;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyAddressMapper {

    int insert(ApplyAddressPO record);

    int insertSelective(ApplyAddressPO record);

    ApplyAddressPO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(ApplyAddressPO record);

    int updateByPrimaryKeySelective(ApplyAddressPO record);

    ApplyAddressPO selectLatestByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplyId(Integer apply_id);

    ApplyAddressPO selectByApplyId(Integer apply_id);

    int countByApplyId(Integer apply_id);
}