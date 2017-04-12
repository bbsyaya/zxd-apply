/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.alibaba.fastjson.JSON;
import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyPageParam;
import com.zhixindu.apply.facade.apply.business.DubboApplyWechatBusiness;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 03/16/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class ApplyWechatBusinessImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyWechatBusinessImpl.class);
    @Inject
    private DubboApplyWechatBusiness applyWechatBusiness;
    @Inject
    private ApplyBankCardMapper applyBankCardMapper;

    @Test
    public void findApplyLoanListTest() {
        ApplyPageParam applyPageParam = new ApplyPageParam(0, 10);
        applyPageParam.setCustomerId("201701161148455852996386");
        PageResult<ApplyLoanBO> applyLoanList = applyWechatBusiness.findApplyLoanList(applyPageParam);
        LOGGER.info(JsonUtil.toJsonString(applyLoanList));
    }

    @Test
    public void findApplyLoanDetailTest() {
        ApplyLoanDetailBO applyLoanDetail = applyWechatBusiness.findApplyLoanDetail(36);
        LOGGER.info(JsonUtil.toJsonString(applyLoanDetail));
    }

    @Test
    public void testFindLatestApplyContact(){
        List<ApplyContactBO> applyContactBOList = applyWechatBusiness.findLatestApplyContact(7);
        applyContactBOList.forEach(applyContactBO -> System.out.println(JSON.toJSON(applyContactBO)));
    }

    @Test
    public void testFindBankCard(){
        ApplyBankCardBO applyBankCardPO = applyBankCardMapper.selectByApplyId(49);
        System.out.println(JSON.toJSONString(applyBankCardPO));
    }



}
