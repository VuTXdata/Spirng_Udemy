package com.vuhocspringboot.springbootdemo.config;

import com.vuhocspringboot.springbootdemo.common.Coach;
import com.vuhocspringboot.springbootdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportCofig {
    @Bean("Vu")
    public Coach swimCoach()
    {
        return  new SwimCoach();
    }
}
