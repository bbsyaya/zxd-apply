package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyContactMapper {

    int insert(ApplyContactBO record);

    int insertSelective(ApplyContactBO record);

    ApplyContactBO selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKey(ApplyContactBO record);

    int updateByPrimaryKeySelective(ApplyContactBO record);

    List<ApplyContactBO> selectLatestByApplicantId(Integer applicant_id);

    List<Integer> selectPrimaryKeyByApplicantId(Integer applicant_id);

    int countByApplicantId(Integer applicant_id);

}