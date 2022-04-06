package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// if i not define a id, the default id is the class name with first letter in lowercase
@Component//("tennisCoach") // bean id = tennisCoach
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside default constructor");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Tennis Coach: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}

	@Autowired
	private void teste(){
		System.out.println(">> TennisCoach: inside teste() method");
	}


}