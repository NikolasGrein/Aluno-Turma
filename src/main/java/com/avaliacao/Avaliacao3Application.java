package com.avaliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Avaliacao3Application {

	public static void main(String[] args) {
		SpringApplication.run(Avaliacao3Application.class, args);
	}

}
