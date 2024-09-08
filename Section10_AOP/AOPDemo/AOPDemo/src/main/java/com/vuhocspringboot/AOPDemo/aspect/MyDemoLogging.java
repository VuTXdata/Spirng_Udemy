package com.vuhocspringboot.AOPDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogging {

    @Around("execution(* getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {

        // print out method we are advising on
        String name = pjp.getSignature().getName();
        System.out.println("====> Name method: " + name);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result =  null;
        try {
            result = pjp.proceed();
        }catch (Exception e) {
            System.out.println("====> Exception: " + e);
            throw e;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("====> Time taken: " + duration + " ms");

        return result;
    }
}
