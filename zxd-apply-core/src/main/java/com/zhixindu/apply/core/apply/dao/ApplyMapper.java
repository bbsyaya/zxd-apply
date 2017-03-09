package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {

    int insert(ApplyBO record);

    int insertSelective(ApplyBO record);

    ApplyBO selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(ApplyBO record);

    int updateByPrimaryKey(ApplyBO record);

    ApplyBO selectLatestByLenderId(Integer lender_id);

    List<ApplyMgtDetailBO> selectListForMgtByPage(ApplyMgtPageParam applyMgtPageParam);

    List<ApplyLoanDetailBO> selectListByPage(ApplyPageParam pageParam);

    int updateStatusByPrimaryKey(ApplyStatusBO applyStatusBO);

    int updateCreditByPrimaryKey(ApplyCreditBO applyCreditBO);
}