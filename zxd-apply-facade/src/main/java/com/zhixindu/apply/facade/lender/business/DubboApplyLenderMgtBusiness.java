package com.zhixindu.apply.facade.lender.business;

/**
 * Created by SteveGuo on 2017/3/3.
 */

import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.apply.facade.lender.bo.LenderMgtQueryParm;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

/**
 * @author SteveGuo
 * @date 2017/3/3
 * @description
 */
public interface DubboApplyLenderMgtBusiness {

    /**
     * 申请人列表
     */
    PageResult<LenderInfoBO>  findLenderInfoByPage(LenderMgtQueryParm param) throws ServiceException;

    /**
     * 通过lender_id获取申请基本信息
     * @throws ServiceException
     */
    LenderMgtInfo getLenderInfo(Integer lender_id) throws ServiceException;


}
