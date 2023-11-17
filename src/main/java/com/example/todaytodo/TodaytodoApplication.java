package com.example.todaytodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan(basePackages = "com.example.todaytodo.Entity")
@EnableJpaRepositories(basePackages = "com.example.todaytodo.Repository")
@SpringBootApplication
public class TodaytodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodaytodoApplication.class, args);
	}

}
