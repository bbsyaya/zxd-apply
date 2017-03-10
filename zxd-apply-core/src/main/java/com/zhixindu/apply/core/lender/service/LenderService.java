package com.zhixindu.apply.core.lender.service;


import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface LenderService {

    boolean isExistLender(String customerId);

    int saveLenderBaseInfo(LenderBaseInfoBO lenderBaseInfoBO);

    int saveOrUpdateAddress(LenderAddressBO lenderAddressBO);

    int saveOrUpdateContact(List<LenderContactBO> lenderContactBOList);

    int saveOrUpdateBankCard(LenderBankCardBO lenderBankCardBO);

    int saveMobileVerify(MobileVerifyBO mobileVerifyBO);

    int saveApplyResult(ApplyResultBO applyResultBO);

}
