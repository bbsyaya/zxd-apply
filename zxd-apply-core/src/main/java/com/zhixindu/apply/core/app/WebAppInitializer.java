package com.zhixindu.apply.core.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author SteveGuo
 * @version 1.0
 * @date 2017/3/3
 * @description Servlet 3.0 to replace web.xml
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebAppConfig.class, AppDataConfig.class);
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
    }

}
