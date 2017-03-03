package com.zhixindu.apply.core.lender.business;

import com.zhixindu.apply.facade.lender.bo.Lender;
import com.zhixindu.apply.facade.lender.bo.LenderAddress;
import com.zhixindu.apply.facade.lender.bo.LenderInfo;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public class LenderWechatBusinessImpl implements DubboApplyLenderWechatBusiness {

    @Override
    public boolean checkCreditSituation(String customerId) {
        return false;
    }

    @Override
    public LenderInfo saveOrFindLender(Lender lender) {
        return null;
    }

    @Override
    public int saveAddress(LenderAddress lenderAddress) {
        return 0;
    }
}
