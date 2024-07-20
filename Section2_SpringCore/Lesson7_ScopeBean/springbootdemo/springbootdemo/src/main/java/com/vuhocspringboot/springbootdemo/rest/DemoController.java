package com.vuhocspringboot.springbootdemo.rest;

import com.vuhocspringboot.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;
    private Coach myCoach2;

    // Define a constructor for the dependency
    @Autowired
    public  void DemoController(@Qualifier("baseballCoach") Coach myCoach, @Qualifier("baseballCoach") Coach myCoach2) {
        this.myCoach = myCoach;
        this.myCoach2 = myCoach2;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "myCoach == myCoach2" + (myCoach == myCoach2);
    }
}