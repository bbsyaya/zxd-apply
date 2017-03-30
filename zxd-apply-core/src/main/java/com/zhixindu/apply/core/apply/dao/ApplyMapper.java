package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApplyMapper {

    int insert(ApplyPO record);

    int insertSelective(ApplyPO record);

    ApplyPO selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(ApplyPO record);

    int updateByPrimaryKey(ApplyPO record);

    ApplyPO selectLatestReviewByApplicantId(Integer applicant_id);

    List<ApplyMgtDetailBO> selectListForMgtByPage(ApplyMgtPageParam applyMgtPageParam);

    List<ApplyLoanDetailBO> selectListByPage(ApplyPageParam pageParam);

    int countNotSettledApply(Integer applicant_id);

    Date selectLastApplyTime(Integer applicant_id);

    Integer selectApplicantIdByPrimaryKey(Integer apply_id);

    Integer selectApplyIdByApplicantId(Integer applicant_id);

    int updateStatusByPrimaryKey(ApplyStatusBO applyStatusBO);

    int updateCreditByPrimaryKey(ApplyCreditBO applyCreditBO);
}