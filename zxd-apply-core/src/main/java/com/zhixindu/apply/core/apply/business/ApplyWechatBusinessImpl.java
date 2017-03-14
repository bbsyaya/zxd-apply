package com.zhixindu.apply.core.apply.business;

import com.google.common.collect.Lists;
import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.core.apply.service.ApplyService;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanStepBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLocationBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStepBO;
import com.zhixindu.apply.facade.apply.business.DubboApplyWechatBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.repository.PageRepository;
import com.zhixindu.commons.utils.Parameters;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("applyWechatBusiness")
public class ApplyWechatBusinessImpl implements DubboApplyWechatBusiness {

    @Inject
    private ApplyService applyService;
    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyStepMapper applyStepMapper;
    @Inject
    private ApplyLocationMapper applyLocationMapper;
    @Inject
    private PageRepository pageRepository;

    @Override
    public ApplyBaseInfoBO findLatestReviewApply(Integer lenderId) {
        Parameters.requireNotNull(lenderId, "lenderId不能为空");
        ApplyBaseInfoBO applyBaseInfoBO = applyMapper.selectLatestReviewByLenderId(lenderId);
        if(null != applyBaseInfoBO) {
            ApplyLocationBO applyLocationBO = applyLocationMapper.selectByApplyId(applyBaseInfoBO.getApply_id());
            applyBaseInfoBO.setOpen_id(applyLocationBO.getOpen_id());
            applyBaseInfoBO.setLatitude(applyLocationBO.getLatitude());
            applyBaseInfoBO.setLongitude(applyLocationBO.getLongitude());
            applyBaseInfoBO.setPrecision(applyLocationBO.getPrecision());
        }
        return applyBaseInfoBO;
    }

    @Override
    public Integer submitApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        Parameters.requireAllPropertyNotNull(applyBaseInfoBO, new Object[]{"apply_id"});
        return applyService.saveApplyLoan(applyBaseInfoBO);
    }

    @Override
    public PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam) {
        Parameters.requireAllPropertyNotNull(pageParam, "分页查询参数不能为空");
        PageResult<ApplyPO> applyBOPageResult = pageRepository.selectPaging(ApplyMapper.class, "selectListByPage", pageParam);
        PageResult<ApplyLoanBO> pageResult = new PageResult<>();
        BeanUtils.copyProperties(applyBOPageResult, pageResult);

        List<ApplyPO> applyPOList = applyBOPageResult.getRows();
        List<ApplyLoanBO> applyLoanBOList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(applyPOList)){
            applyLoanBOList = applyPOList.stream().map(applyBO -> {
                ApplyLoanBO applyLoanBO = new ApplyLoanBO();
                BeanUtils.copyProperties(applyBO, applyLoanBO);
                applyLoanBO.setApply_time(new DateTime(applyBO.getApply_time()).toString("yyyy-MM-dd"));
                applyLoanBO.setApply_status(applyService.getLatestApplyStatus(applyBO.getApply_id()));
                return applyLoanBO;
            }).collect(Collectors.toList());
        }
        pageResult.setRows(applyLoanBOList);
        return pageResult;
    }

    @Override
    public ApplyLoanDetailBO findApplyLoanDetail(Integer applyId) {
        Parameters.requireNotNull(applyId, "applyId不能为空");
        ApplyLoanDetailBO applyLoanDetailBO = new ApplyLoanDetailBO();
        ApplyPO applyPO = applyMapper.selectByPrimaryKey(applyId);
        if(null == applyPO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有匹配的申请借款记录");
        }
        BeanUtils.copyProperties(applyPO, applyLoanDetailBO);

        List<ApplyStepBO> applyStepBOList = applyStepMapper.selectListByApplyId(applyId);
        List<ApplyLoanStepBO> applyLoanStepBOList = Lists.newArrayListWithCapacity(0);
        if(CollectionUtils.isNotEmpty(applyStepBOList)) {
            applyLoanStepBOList = applyStepBOList.stream().map(instanceBO -> {
                ApplyLoanStepBO applyWorkflowBO = new ApplyLoanStepBO();
                applyWorkflowBO.setProcess_result(instanceBO.getProcess_step().getDesc() + instanceBO.getProcess_state().getDesc());
                if (null != instanceBO.getProcess_time()) {
                    applyWorkflowBO.setProcess_time(new DateTime(instanceBO.getProcess_time()).toString
                            ("yyyy-MM-dd HH:mm:ss"));
                }
                return applyWorkflowBO;
            }).collect(Collectors.toList());
        }
        applyLoanDetailBO.setApplyLoanStepBOList(applyLoanStepBOList);
        return applyLoanDetailBO;
    }

    @Override
    public boolean submitApplyStatus(ApplyStatusBO applyStatusBO) {
        Parameters.requireAllPropertyNotNull(applyStatusBO);
        return applyService.updateApplyStatus(applyStatusBO) > 0;
    }

    @Override
    public boolean submitApplyCredit(ApplyCreditBO applyCreditBO) {
        Parameters.requireAllPropertyNotNull(applyCreditBO);
        return applyService.updateApplyCredit(applyCreditBO) > 0;
    }
}
