package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class Pencil implements Writer{

    public void write(){
        System.out.println("write using pencil");
    }
}
