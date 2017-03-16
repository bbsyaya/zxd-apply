/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.DatabaseConfig;
import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.facade.apply.bo.ApplyLoanBO;
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

/**
 * @author Richard Xue
 * @version 1.0
 * @date 03/16/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DatabaseConfig.class})
@WebAppConfiguration
public class ApplyWechatBusinessImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyWechatBusinessImpl.class);
    @Inject
    private DubboApplyWechatBusiness applyWechatBusiness;

    @Test
    public void findApplyLoanListTest() {
        ApplyPageParam applyPageParam = new ApplyPageParam(0, 10);
        applyPageParam.setCustomerId("201701161148455852996386");
        PageResult<ApplyLoanBO> applyLoanList = applyWechatBusiness.findApplyLoanList(applyPageParam);
        LOGGER.info(JsonUtil.toJsonString(applyLoanList));
    }

    @Test
    public void findApplyLoanDetailTest() {

    }

}
