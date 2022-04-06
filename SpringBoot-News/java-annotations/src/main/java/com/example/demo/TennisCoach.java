package com.example.demo;

import org.springframework.stereotype.Component;

// if i not define a id, the default id is the class name with first letter in lowercase
@Component//("tennisCoach") // bean id = tennisCoach
public class TennisCoach implements Coach {

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
