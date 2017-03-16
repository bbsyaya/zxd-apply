/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.aop;

import com.alibaba.fastjson.JSON;
import com.zhixindu.commons.utils.CommonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        LOGGER.info("before :: {}.{} >>>>> {}", name, method, JSON.toJSONString(args));
    }

    @After("query()")
    public void doAfterTask(JoinPoint joinPoint) {
    }

    @AfterReturning(pointcut = "query()", returning = "result")
    public void doAfterReturningTask(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method = joinPoint.getSignature().getName();
        LOGGER.info("after :: {}.{} >>>>> {}", name, method, CommonUtil.convert(result));
    }

    @AfterThrowing(pointcut = "query()", throwing = "ex")
    public void doAfterThrowingTask(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
        LOGGER.error(name, ex);
    }

}
