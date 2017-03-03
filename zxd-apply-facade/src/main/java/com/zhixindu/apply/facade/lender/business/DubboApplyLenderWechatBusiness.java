package com.zhixindu.apply.facade.lender.business;

import com.zhixindu.apply.facade.lender.bo.Lender;
import com.zhixindu.apply.facade.lender.bo.LenderAddress;
import com.zhixindu.apply.facade.lender.bo.LenderInfo;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyLenderWechatBusiness {

    /**
     * 检查借款人信用情况
     * @param customerId
     * @return
     */
    boolean checkCreditSituation(String customerId);

    /**
     * 根据customerId查找借款人信息
     * 如果不存在就保存借款人信息
     * 对借款人信息做掩码并放回
     * @param lender
     * @return
     */
    LenderInfo saveOrFindLender(Lender lender);

    /**
     * 保存借款人地址信息
     * @param lenderAddress
     * @return
     */
    int saveAddress(LenderAddress lenderAddress);

}
