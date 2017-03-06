/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.DatabaseConfig;
import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.core.lender.business.LenderMgtBusiness;
import com.zhixindu.apply.core.lender.business.LenderMgtBusinessImpl;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.apply.facade.lender.bo.VerifyInfo;
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
 * @date 08/16/2016
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DatabaseConfig.class})
@WebAppConfiguration
public class MgtBusinessImplTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MgtBusinessImplTest.class);
    @Inject
    private LenderMgtBusiness lenderMgtBusiness;

    @Test
    public void test() {
        LenderMgtInfo info = lenderMgtBusiness.getLenderInfo("123456");
        System.out.println(JsonUtil.toJsonString(info));
    }
}
