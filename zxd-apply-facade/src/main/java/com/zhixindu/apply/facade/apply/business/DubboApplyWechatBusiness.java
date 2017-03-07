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

    boolean submitApplyLoan(ApplyBO applyBO);

    PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam);

    ApplyLoanDetailBO findApplyLoanDetail(Integer applyId);

}
