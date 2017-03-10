package com.zhixindu.apply.core.apply.business;


import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfo;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import com.zhixindu.apply.facade.apply.business.DubboApplyMgtBusiness;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.repository.PageRepository;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("applyMgtBusiness")
public class ApplyMgtBusinessImpl implements DubboApplyMgtBusiness {

    @Inject
    private ApplyMapper applyMapper;

    @Inject
    private ApplyStepMapper applyStepMapper;

    @Inject
    private PageRepository pageRepository;

    @Override
    public ApplyMgtInfo getApplyInfoByLenderId(Integer apply_id) throws ServiceException {
        Parameters.requireNotNull(apply_id,"getApplyInfoByLenderId lender_id illargm_param");
        ApplyPO applyPO = applyMapper.selectByPrimaryKey(apply_id);
        if(null == applyPO){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询不到申请的借款信息!");
        }
        ApplyMgtInfo applyMgtInfo = new ApplyMgtInfo();
        BeanUtils.copyProperties(applyMgtInfo,applyPO);
        return applyMgtInfo;
    }

    @Override
    public PageResult<ApplyMgtDetailBO> selectApplysByPage(ApplyMgtPageParam pageParam) throws ServiceException {
        Parameters.requireNotNull(pageParam.getPage(),"分页查询参数page不能为空");
        Parameters.requireNotNull(pageParam.getCount(),"分页查询参数count不能为空");
        PageResult<ApplyMgtBO> pageResult = pageRepository.selectPaging(ApplyMapper.class,"selectListForMgtByPage",pageParam);
        if(pageResult == null){
            return new PageResult<>(new ArrayList<>(0), 0);
        }
        PageResult<ApplyMgtDetailBO> detailBOPageResult = new PageResult<>();
        BeanUtils.copyProperties(pageResult,detailBOPageResult);
        List<ApplyMgtBO> applyMgtBOs = pageResult.getRows();
        List<ApplyMgtDetailBO> applyMgtDetailBOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(applyMgtBOs)){
            applyMgtDetailBOList = applyMgtBOs.stream().map(applyMgtBO -> {
                ApplyMgtDetailBO applyMgtDetailBO = new ApplyMgtDetailBO();
                BeanUtils.copyProperties(applyMgtBO, applyMgtDetailBO);
                ApplyStepBO applyStepBO = applyStepMapper.selectByApplyId(applyMgtBO.getApply_id(), ProcessStep.LOAN.getValue());
                if (applyStepBO == null) {
                    applyMgtDetailBO.setProcess_time(null);
                } else {
                    applyMgtDetailBO.setProcess_time(applyStepBO.getProcess_time());
                }
                return applyMgtDetailBO;
            }).collect(Collectors.toList());
        }
        detailBOPageResult.setRows(applyMgtDetailBOList);
        return detailBOPageResult;
    }
}
