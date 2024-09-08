package com.vuhocspringboot.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectException {
    @Pointcut("execution(* com.vuhocspringboot.AOPDemo.*.*(..))")
    public void pointcut() {}

    @Pointcut("execution(* findAccount())")
    public void findAccount() {}
}
