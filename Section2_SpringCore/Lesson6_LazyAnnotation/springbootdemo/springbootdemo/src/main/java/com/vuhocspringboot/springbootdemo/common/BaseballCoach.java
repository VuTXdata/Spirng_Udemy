package com.vuhocspringboot.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("BaseballCoach Constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball Coach";
    }
}
