package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveApplyLoan(ApplyBO applyBO) {
        return applyMapper.insertSelective(applyBO);
    }

}
