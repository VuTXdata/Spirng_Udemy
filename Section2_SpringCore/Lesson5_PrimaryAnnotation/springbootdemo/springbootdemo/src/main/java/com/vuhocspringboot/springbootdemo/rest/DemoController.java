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

    // Define a constructor for the dependency
    @Autowired
    public  void DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}