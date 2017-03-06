package com.zhixindu.apply.facade.lender.business;

/**
 * Created by SteveGuo on 2017/3/3.
 */

import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.commons.api.ServiceException;

/**
 * @author SteveGuo
 * @date 2017/3/3
 * @description
 */
public interface DubboApplyLenderMgtBusiness {

    /**
     * 通过customerId获取申请基本信息
     * @throws ServiceException
     */
    LenderMgtInfo getLenderInfo(String customerId) throws ServiceException;


}
