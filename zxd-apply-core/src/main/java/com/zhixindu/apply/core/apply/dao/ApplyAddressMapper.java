package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.core.apply.po.ApplyAddressPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyAddressMapper {

    int insert(ApplyAddressPO record);

    int insertSelective(ApplyAddressPO record);

    ApplyAddressPO selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKey(ApplyAddressPO record);

    int updateByPrimaryKeySelective(ApplyAddressPO record);

    ApplyAddressPO selectLatestByApplicantId(Integer applicant_id);

    List<ApplyAddressPO> selectByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplyId(Integer apply_id);

    ApplyAddressPO selectByApplyId(Integer apply_id);

    int countByApplyId(Integer apply_id);

    int countByApplicantId(Integer applicant_id);
}