package com.example.demo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach") // bean id = thatSillyCoach
public class TennisCoach implements Coach {

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
