/*
 * Copyright (C) 2017 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.aop;

import com.alibaba.fastjson.JSON;
import com.zhixindu.commons.utils.CommonUtil;
import com.zhixindu.commons.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * 业务层参数输出切面
 * Created by SteveGuo on 2017/3/16.
 */
@Aspect
@Component
public class BusinessParameterAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessParameterAspect.class);

    @Pointcut("execution(* com.zhixindu.apply.core.*.business.*.*(..))")
    private void query() {
    }

    @Before("query()")
    public void doBeforeTask(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("before :: {}.{} >>>>> {}", name, method, JSON.toJSONString(args));
        }
    }

    @AfterReturning(pointcut = "query()", returning = "result")
    public void doAfterReturningTask(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method = joinPoint.getSignature().getName();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("after :: {}.{} >>>>> {}", name, method, CommonUtil.convert(result));
        }
    }

    @AfterThrowing(pointcut = "query()", throwing = "ex")
    public void doAfterThrowingTask(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String key = MessageFormat.format("{0}.{1} >>>>> {2}", name, method, JsonUtil.toJsonString(args));
        LOGGER.error(key, ex);
    }

}
