package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.commons.page.PageResult;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyWechatBusiness {

    /**
     * 提交申请借款
     * @param applyBO
     * @return
     */
    boolean submitApplyLoan(ApplyBO applyBO);

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

}
