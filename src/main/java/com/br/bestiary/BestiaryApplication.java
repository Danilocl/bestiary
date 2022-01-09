package com.br.bestiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Beastiary API", version = "1.0", description = "API for beasts!!"))
public class BestiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestiaryApplication.class, args);
	}

}
