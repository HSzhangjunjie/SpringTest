package com.test.uils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/21 8:32
 */
@Component
@Aspect
public class Logger {
    /**
     * 向控制台打印日志，作为前置通知
     */
    @Before("execution(* com.test.service.impl.*.* (..))")
    public void printLog(){
        System.out.println("Logger类中的日志方法开始记录日志");
    }
}
