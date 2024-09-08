package com.vuhocspringboot.AOPDemo.aspect;

import com.vuhocspringboot.AOPDemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DemoAfterAdvice {
    @AfterReturning(
            pointcut = "com.vuhocspringboot.AOPDemo.aspect.AspectException.findAccount()",
            returning = "result")
    public void afterAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("Before Advice: " + result);
        processResult(result);
        System.out.println("After Advice: " + result);
    }

    private void processResult(List<Account> result) {
        for (Account account : result) {
            String username = account.getUsername().toUpperCase();
            account.setUsername(username);
        }
    }
}
