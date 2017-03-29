/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.core.applicant.business.ApplicantMgtBusinessImpl;
import com.zhixindu.commons.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * @author yulei
 * @version 1.0
 * @date 03/06/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class ApplicantMgtBusinessImplTest {

    @Inject
    private ApplicantMgtBusinessImpl applicantMgtBusiness;


    @Test
    public void getApplicantTest(){
        System.out.println("afsdfasfd");
        System.out.println(JsonUtil.toJsonString(applicantMgtBusiness.findApplicantInfo(1)));
    }

}
