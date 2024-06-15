package com.douglas.springkafka;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringkafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EntityManager entityManager) {
		return args -> {
			entityManager.createQuery("SELECT 1").getSingleResult();
			System.out.println("Conexão com o banco de dados H2 foi bem-sucedida!");
		};
	}

}
