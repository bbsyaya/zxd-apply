package com.zhixindu.apply.core;

import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.core.app.DatabaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by SteveGuo on 2017/3/27.
 */
public class DubboApplicationProvider {

    private final static Logger LOGGER = LoggerFactory.getLogger(DubboApplicationProvider.class);

    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.register(ApplicationContextConfig.class, DatabaseConfig.class);
            context.refresh();
            context.start();
        } catch (Exception e) {
            LOGGER.error("Apply DubboApplicationProvider context start error:", e);
        }
        synchronized (DubboApplicationProvider.class) {
            while (true) {
                try {
                    DubboApplicationProvider.class.wait();
                } catch (InterruptedException e) {
                    LOGGER.error("synchronized error:", e);
                }
            }
        }
    }
}
