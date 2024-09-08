package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogingAspect {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forControllerPackage() {
    }
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forServicePackage() {
    }
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display method we are calling
        String methodName = joinPoint.getSignature().getName();
        logger.info("=====> in @Before: calling method: " + methodName);

        // display the argument to the method
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("=====> argument: " + arg);
        }

    }
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinPoint, Object theResult)
    {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=====> in @After: calling method: " + methodName);

        System.out.println("=====> result: " + theResult);
    }
}
