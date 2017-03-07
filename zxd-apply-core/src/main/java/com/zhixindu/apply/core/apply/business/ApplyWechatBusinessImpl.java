package com.zhixindu.apply.core.apply.business;

import com.google.common.collect.Lists;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.service.ApplyService;
import com.zhixindu.apply.core.workflow.dao.WorkflowStepInstanceMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.business.DubboApplyWechatBusiness;
import com.zhixindu.apply.facade.workflow.bo.ApplyLoanWorkflowStepBO;
import com.zhixindu.apply.facade.workflow.bo.WorkflowStepInstanceBO;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.repository.PageRepository;
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
    private WorkflowStepInstanceMapper workflowStepInstanceMapper;
    @Inject
    private PageRepository pageRepository;

    @Override
    public boolean submitApplyLoan(ApplyBO applyBO) {
        return applyService.saveApplyLoan(applyBO) > 0;
    }

    @Override
    public PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam) {
        return null;
    }

    @Override
    public ApplyLoanDetailBO findApplyLoanDetail(Integer applyId) {
        ApplyLoanDetailBO applyLoanDetailBO = new ApplyLoanDetailBO();
        ApplyBO applyBO = applyMapper.selectByPrimaryKey(applyId);
        if(null == applyBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有匹配的申请借款记录");
        }
        BeanUtils.copyProperties(applyBO, applyLoanDetailBO);
        List<WorkflowStepInstanceBO> workflowStepInstanceBOList = workflowStepInstanceMapper.selectListByApplyId(applyId);
        List<ApplyLoanWorkflowStepBO> applyLoanWorkflowStepBOList = Lists.newArrayListWithCapacity(0);
        if(CollectionUtils.isNotEmpty(workflowStepInstanceBOList)) {
            applyLoanWorkflowStepBOList = workflowStepInstanceBOList.stream().map(instanceBO -> {
                ApplyLoanWorkflowStepBO applyWorkflowBO = new ApplyLoanWorkflowStepBO();
                applyWorkflowBO.setProcessing_result(instanceBO.getStep_definition_id().getDesc() + instanceBO
                        .getProcessing_state().getValue());
                if (null != instanceBO.getProcessing_time()) {
                    applyWorkflowBO.setProcessing_time(new DateTime(instanceBO.getProcessing_time()).toString
                            ("yyyy-MM-dd HH:mm:ss"));
                }
                return applyWorkflowBO;
            }).collect(Collectors.toList());
        }
        applyLoanDetailBO.setApplyLoanWorkflowStepList(applyLoanWorkflowStepBOList);
        return applyLoanDetailBO;
    }
}
