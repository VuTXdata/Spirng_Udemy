package com.vuhocspringboot.springbootdemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    public CricketCoach() {
        System.out.println("CricketCoach Constructor" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Criket Coach!";
    }
}
