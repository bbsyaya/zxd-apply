package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyAddressMapper {

    int insert(ApplyAddressBO record);

    int insertSelective(ApplyAddressBO record);

    ApplyAddressBO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(ApplyAddressBO record);

    int updateByPrimaryKeySelective(ApplyAddressBO record);

    ApplyAddressBO selectLatestByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplyId(Integer apply_id);

    ApplyAddressBO selectByApplyId(Integer apply_id);

    int countByApplyId(Integer apply_id);
}