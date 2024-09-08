package com.vuhocspringboot.AOPDemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        // Simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // reuturn fortune
        return "Except heavy traffic this morning!";
    }
}
