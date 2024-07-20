package com.vutxdata.Lesson01_1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunResController {
    @GetMapping("/")
    public String getHello()
    {
        return "Hello world!";
    }
    @GetMapping("/page1")
    public String getpage12()
    {
        return "Welcome to the page1!";
    }
    @GetMapping("/page2")
    public String getpage()
    {
        return "Welcome to the page2!";
    }
    @GetMapping("/page3")
    public String getpage3()
    {
        return "Welcome to the page3!";
    }
    @GetMapping("/page4")
    public String getpage4()
    {
        return "Welcome to the page4!";
    }
}
