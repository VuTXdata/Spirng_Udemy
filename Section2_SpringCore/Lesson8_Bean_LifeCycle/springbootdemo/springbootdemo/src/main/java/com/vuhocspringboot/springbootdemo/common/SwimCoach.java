package com.vuhocspringboot.springbootdemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In SwimCoach: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim Coach";
    }
}
