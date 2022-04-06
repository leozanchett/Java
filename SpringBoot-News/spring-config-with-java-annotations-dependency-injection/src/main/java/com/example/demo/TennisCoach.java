package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// if i not define a id, the default id is the class name with first letter in lowercase
@Component//("tennisCoach") // bean id = tennisCoach
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneTwo") // quando há dois ou mais métodos iguais que sobreescrevem o método getFortune()
								  // então é definido um @Qualifier para diferenciar qual o método que será utilizado
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Tennis Coach: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Autowired
	private void teste(){
		System.out.println(">> TennisCoach: inside teste() method");
	}


}