package com.vuhocspringboot.springbootdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("TrackCoach Constructor" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Track Coach";
    }
}
