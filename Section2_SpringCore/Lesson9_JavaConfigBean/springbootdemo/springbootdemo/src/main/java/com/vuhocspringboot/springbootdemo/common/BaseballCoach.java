package com.vuhocspringboot.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("BaseballCoach Constructor" + getClass().getSimpleName());
    }
    // Define our inti method
    @PostConstruct
    public void init() {
        System.out.println("In init method" + getClass().getSimpleName());
    }
    @PreDestroy
    public void destroy() {
        System.out.println("In destroy method" + getClass().getSimpleName());
    }

    // Define our destroy method

    @Override
    public String getDailyWorkout() {
        return "Baseball Coach";
    }

}
