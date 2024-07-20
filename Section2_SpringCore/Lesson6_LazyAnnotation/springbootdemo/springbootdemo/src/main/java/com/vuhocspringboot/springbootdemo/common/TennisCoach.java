package com.vuhocspringboot.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("TennisCoach Constructor" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach";
    }
}
