package com.stefanini.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	// necessário "forçar" o bean do BCrypt pois não é uma classe que se auto instancia somente como @Autowired
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public AppConfig() {
		// TODO Auto-generated constructor stub
	}

}
