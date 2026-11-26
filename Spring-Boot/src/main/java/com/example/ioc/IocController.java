package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IocController {
    @Autowired
    IocService i;
    @GetMapping("/hello")
    public String hello(){
        return i.hello1();
    }
}
