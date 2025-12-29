package com.example.app.estudo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class EstudoSpringApplication {
	public static void main(String[] args) {
		Dotenv env = Dotenv.load();
		env.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

}
