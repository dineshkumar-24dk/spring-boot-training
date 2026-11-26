package com.example.ioc;

import org.springframework.stereotype.Service;

@Service
public class IocService {
    public String hello1(){
        return "Hello Service";
    }
}
