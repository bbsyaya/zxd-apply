/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.apply.facade.apply.business.DubboApplyMgtBusiness;
import com.zhixindu.commons.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 03/16/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class ApplyMgtBusinessTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyMgtBusinessTest.class);

    @Inject
    private DubboApplyMgtBusiness applyMgtBusiness;

    @Test
    public void testSelectApplysByPage(){
        ApplyMgtPageParam pageParam = new ApplyMgtPageParam();
        pageParam.setPage(1);
        pageParam.setCount(10);
//        pageParam.setApply_id("46");
        pageParam.setApplicant_id("46");
//        pageParam.setApply_status(ApplyStatus.REVIEW_FAIL);
//        System.out.println(JsonUtil.toJsonString(pageParam));
        System.out.println(JsonUtil.toJsonString(applyMgtBusiness.selectApplysByPage(pageParam)));
    }

    @Test
    public void testFindApplyInfoByApplyId(){
//        ApplyMgtInfo info = applyMgtBusiness.findApplyInfoByApplyId(1);
//        System.out.println(JsonUtil.toJsonString(info));

    }
    @Test
    public void testFindApplyBankCardByApplyId(){
        //49
        ApplyBankCardMgtBO info = applyMgtBusiness.findBankCardByApplyId(50);
        System.out.println(JsonUtil.toJsonString(info));

    }

    @Test
    public void testFindBankCardByApplyId(){
        applyMgtBusiness.findBankCardByApplyId(49);
    }



}
