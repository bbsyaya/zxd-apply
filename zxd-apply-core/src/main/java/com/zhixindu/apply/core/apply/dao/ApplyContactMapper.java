package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.core.apply.po.ApplyContactPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyContactMapper {

    int insert(ApplyContactPO record);

    int insertSelective(ApplyContactPO record);

    ApplyContactPO selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKey(ApplyContactPO record);

    int updateByPrimaryKeySelective(ApplyContactPO record);

    List<ApplyContactPO> selectLatestByApplicantId(Integer applicant_id);

    List<Integer> selectPrimaryKeyByApplyId(Integer apply_id);

    List<ApplyContactPO> selectByApplyId(Integer apply_id);

    int countByApplyId(Integer apply_id);

}