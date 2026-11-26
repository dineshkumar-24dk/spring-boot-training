package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
    int age;

    @Autowired
    @Qualifier("pen")
    Writer w;
    public void study(){
        System.out.println("i am studying");
    }
    public void exam(){
        w.write();
    }
}
