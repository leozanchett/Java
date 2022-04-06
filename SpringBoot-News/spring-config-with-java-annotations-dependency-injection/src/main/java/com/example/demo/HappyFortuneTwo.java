package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneTwo{ /* implements{FortuneService {
                                            @Override*/
    public String getFortune() {
        return "Today is great lucky day! You will be happy!  "+this.getClass().getName();
    }
}
