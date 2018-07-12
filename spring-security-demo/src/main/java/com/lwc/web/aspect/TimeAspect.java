package com.lwc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author eddie.lee
 * @Package com.lwc.web.aspect
 * @ClassName TimeAspect
 * @description AOP切片配置
 * @date created in 2018-07-12 23:36
 * @modified by
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.lwc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("TimeAspect ==>time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("TimeAspect ==> arg is " + arg);
        }

        long start = new Date().getTime();

        Object object = pjp.proceed();

        System.out.println("TimeAspect ==> time aspect 耗时:" + (new Date().getTime() - start));

        System.out.println("TimeAspect ==> time aspect end");

        return object;
    }

}

