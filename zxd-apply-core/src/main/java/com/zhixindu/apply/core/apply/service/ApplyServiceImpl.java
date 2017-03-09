package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/7.
 */
@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyStepMapper applyStepMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveApplyLoan(ApplyBO applyBO) {
        return applyMapper.insertSelective(applyBO);
    }

    @Override
    public String getLatestApplyStatus(Integer applyId) {
        ApplyStepBO applyStepBO = applyStepMapper.selectLatestByApplyId(applyId);
        return applyStepBO.getProcess_step().getDesc() + applyStepBO.getProcess_state().getDesc();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyStatus(ApplyStatusBO applyStatusBO) {
        return applyMapper.updateApplyStatusByPrimaryKey(applyStatusBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyCredit(ApplyCreditBO applyCreditBO) {
        return applyMapper.updateCreditByPrimaryKey(applyCreditBO);
    }

}
