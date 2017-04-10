package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.facade.system.business.DubboSystemConfigBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class SystemConfigBusinessTest {

    @Inject
    private DubboSystemConfigBusiness systemConfigBusiness;

    @Test
    public void testGetRegionFullName(){
        System.out.println(systemConfigBusiness.getRegionFullName(3101));
    }

    @Test
    public void testGetRegionList(){
        System.out.println(systemConfigBusiness.getRegionList(3101));
    }

}
