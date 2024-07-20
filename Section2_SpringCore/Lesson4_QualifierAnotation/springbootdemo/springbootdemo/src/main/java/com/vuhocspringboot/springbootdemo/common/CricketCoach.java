package com.vuhocspringboot.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Criket Coach!";
    }
}
