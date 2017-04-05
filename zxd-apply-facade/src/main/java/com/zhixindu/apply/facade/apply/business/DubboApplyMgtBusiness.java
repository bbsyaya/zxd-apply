package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.ApplyBankCardMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfo;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyMgtBusiness {

    /**
     * 获取申请借款信息
     * @param apply_id
     * @return
     * @throws ServiceException
     */
    ApplyMgtInfo findApplyInfoByApplyId(Integer apply_id) throws ServiceException;

    /**
     * 获取银行卡信息
     * @param apply_id
     * @return
     * @throws ServiceException
     */
    ApplyBankCardMgtBO findBankCardByApplyId(Integer apply_id) throws ServiceException;

    /**
     * 获取申请借款列表
     * @throws ServiceException
     */
    PageResult<ApplyMgtDetailBO> selectApplysByPage(ApplyMgtPageParam pageParam) throws ServiceException;
}
