package com.vuhocspringboot.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice 15 minutes!!!";
    }
}
