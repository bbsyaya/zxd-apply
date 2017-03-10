package com.zhixindu.apply.facade.apply.business;

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
     * 是否申请审核不通过失效
     * 时间为从审核不通过的时间算起一个月
     * @param lenderId
     * @return
     */
    boolean isRejectApplyExpired(Integer lenderId);

    /**
     * 获取最新的申请记录
     * @param lenderId
     * @return
     */
    ApplyBaseInfoBO findLatestApplyByLenderId(Integer lenderId);

    /**
     * 提交申请借款
     * @param applyBaseInfoBO
     * @return
     */
    boolean submitApplyLoan(ApplyBaseInfoBO applyBaseInfoBO);

    /**
     * 查询申请借款记录
     * @param pageParam
     * @return
     */
    PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam);

    /**
     * 查询申请借款详情
     * @param applyId
     * @return
     */
    ApplyLoanDetailBO findApplyLoanDetail(Integer applyId);

    /**
     * 提交申请状态
     * @param applyStatusBO
     * @return
     */
    boolean submitApplyStatus(ApplyStatusBO applyStatusBO);

    /**
     * 提交申请信用
     * @param applyCreditBO
     * @return
     */
    boolean submitApplyCredit(ApplyCreditBO applyCreditBO);

}
