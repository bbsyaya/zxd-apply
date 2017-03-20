package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.commons.page.PageResult;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyWechatBusiness {

    /**
     * 距离上次申请是否在一个月内
     * @param lenderId
     * @return
     */
    boolean isBeforeAMonthFromLastApply(Integer lenderId);

    /**
     * 是否有未结清的贷款申请
     * @param lenderId
     * @return
     */
    boolean hasNotSettledApply(Integer lenderId);

    /**
     * 获取最新的申请记录，状态处于审核中、审核通过
     * @param lenderId
     * @return 申请借款基本信息
     */
    ApplyBaseInfoBO findLatestReviewApply(Integer lenderId);

    /**
     * 提交申请借款
     * @param applyBaseInfoBO
     * @return 申请ID
     */
    Integer submitApplyLoan(ApplyBaseInfoBO applyBaseInfoBO);

    /**
     * 查询申请借款记录
     * @param pageParam
     * @return 申请借款分页结果
     */
    PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam);

    /**
     * 查询申请借款详情
     * @param applyId
     * @return
     */
    ApplyLoanDetailBO findApplyLoanDetail(Integer applyId);

    /**
     * 获取申请基本信息
     * @param applyId
     * @return
     */
    ApplyBO findApply(Integer applyId);

    /**
     * 提交申请信用
     * @param applyCreditBO
     * @return 是否成功
     */
    boolean submitApplyCredit(ApplyCreditBO applyCreditBO);

    /**
     * 提交放款状态
     * @param applyStatusBO
     * @return 是否成功
     */
    boolean submitLoanStatus(ApplyStatusBO applyStatusBO);

    /**
     * 提交还款状态
     * @param applyStatusBO
     * @return
     */
    boolean submitRepaymentStatus(ApplyStatusBO applyStatusBO);

}
