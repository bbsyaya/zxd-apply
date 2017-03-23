/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.core.apply.business.ApplyMgtBusinessImpl;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfo;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.commons.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/8
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class ApplyBusinessImplTest {

    @Inject
    private ApplyMgtBusinessImpl applyMgtBusiness;

    @Test
    public void testSelectApplysByPage(){
        ApplyMgtPageParam pageParam = new ApplyMgtPageParam();
//        pageParam.setPage(0);
//        pageParam.setCount(10);
//        //pageParam.setApply_status(ApplyStatus.UNDER_REVIEW);
//        System.out.println(JsonUtil.toJsonString(pageParam));
//        System.out.println(JsonUtil.toJsonString(applyMgtBusiness.selectApplysByPage(pageParam)));
    }

    @Test
    public void testFindApplyInfoByLenderId(){
        ApplyMgtInfo info = applyMgtBusiness.findApplyInfoByApplyId(1);
        System.out.println(JsonUtil.toJsonString(info));

    }
}
