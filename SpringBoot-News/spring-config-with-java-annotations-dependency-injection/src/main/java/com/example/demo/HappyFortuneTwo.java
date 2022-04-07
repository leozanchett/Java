package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties("foo")
public class HappyFortuneTwo implements FortuneService {

    @Value("${nome}")
    private String nome;

    // create an array of strings
    private final String[] fortunes = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private final Random randomNumberGenerator = new Random();

    @Override
    public String getFortune() {
        // pick a random string from the array
        System.out.println("Nome: " + nome);
        int index = randomNumberGenerator.nextInt(fortunes.length);
        return fortunes[index];
    }

}
