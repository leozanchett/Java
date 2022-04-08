package com.geral.geral;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeralApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 404;
	}

	public static void main(String[] args) {
		System.exit(SpringApplication.exit((SpringApplication.run(GeralApplication.class, args
		))));
	}

}
