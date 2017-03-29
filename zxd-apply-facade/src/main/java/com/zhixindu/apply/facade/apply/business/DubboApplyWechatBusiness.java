package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyWechatBusiness {

    /**
     * 距离上次申请是否在一个月内
     * @param applicantId
     * @return
     */
    boolean isBeforeAMonthFromLastApply(Integer applicantId) throws ServiceException;

    /**
     * 是否有未结清的贷款申请
     * @param applicantId
     * @return
     */
    boolean hasNotSettledApply(Integer applicantId) throws ServiceException;

    /**
     * 获取最新的申请记录，状态处于审核中、审核通过
     * @param applicantId
     * @return 申请借款基本信息
     */
    ApplyBaseInfoBO findLatestReviewApply(Integer applicantId) throws ServiceException;

    /**
     * 根据applicantId查找申请人地址信息
     * @param applicantId
     * @return 申请人地址信息
     */
    ApplyAddressBO findApplyAddress(Integer applicantId);

    /**
     * 根据applicantId查找申请人联系人信息
     * @param applicantId
     * @return 申请人联系人列表
     */
    List<ApplyContactBO> findApplyContact(Integer applicantId);

    /**
     * 根据申请人ID查找银行卡信息
     * @param applicantId
     * @return 申请人银行卡信息
     */
    ApplyBankCardBO findApplyBankCard(Integer applicantId);

    /**
     * 提交申请人地址信息
     * @param applyAddressBO
     * @return 地址ID
     */
    Integer submitApplyAddress(ApplyAddressBO applyAddressBO);

    /**
     * 提交申请人联系人信息
     * @param applyContactBOList
     * @return  联系人ID列表
     */
    List<Integer> submitApplyContact(List<ApplyContactBO> applyContactBOList);

    /**
     * 提交申请人银行卡信息
     * @param applyBankCardBO
     * @return 银行卡ID
     */
    Integer submitApplyBankCard(ApplyBankCardBO applyBankCardBO);

    /**
     * 提交申请借款
     * @param applyBaseInfoBO
     * @return 申请ID
     */
    Integer submitApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) throws ServiceException;

    /**
     * 查询申请借款记录
     * @param pageParam
     * @return 申请借款分页结果
     */
    PageResult<ApplyLoanBO> findApplyLoanList(ApplyPageParam pageParam) throws ServiceException;

    /**
     * 查询申请借款详情
     * @param applyId
     * @return
     */
    ApplyLoanDetailBO findApplyLoanDetail(Integer applyId) throws ServiceException;

    /**
     * 获取申请基本信息
     * @param applyId
     * @return
     */
    ApplyBO findApply(Integer applyId) throws ServiceException;

    /**
     * 提交申请信用
     * @param applyCreditBO
     * @return 是否成功
     */
    boolean submitApplyCredit(ApplyCreditBO applyCreditBO) throws ServiceException;

    /**
     * 提交放款状态
     * @param applyStatusBO
     * @return 是否成功
     */
    boolean submitLoanStatus(ApplyStatusBO applyStatusBO) throws ServiceException;

    /**
     * 提交还款状态
     * @param applyStatusBO
     * @return
     */
    boolean submitRepaymentStatus(ApplyStatusBO applyStatusBO) throws ServiceException;

}
