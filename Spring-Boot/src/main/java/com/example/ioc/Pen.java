package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class Pen implements Writer{
    Pen(){
        System.out.println("pen object");
    }
    public void write() {
        System.out.println("Writing using Pen");
    }
}