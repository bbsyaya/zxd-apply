package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {

    int insert(ApplyBO record);

    int insertSelective(ApplyBO record);

    ApplyBO selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(ApplyBO record);

    int updateByPrimaryKey(ApplyBO record);

    ApplyBO selectByLenderId(Integer lender_id);

    List<ApplyMgtDetailBO> selectLoansByPage(ApplyMgtPageParam parm);

}