package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // bean id = tennisCoach
//@Component("myCoach") // bean id = myCoach se não for definido um nome para o componente será o nome da classe com a primeira letra em lowercase
@Scope("prototype") // bean scope = prototype significa que quero criar uma instancia diferente, toda vez que a classe for instanciada.
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