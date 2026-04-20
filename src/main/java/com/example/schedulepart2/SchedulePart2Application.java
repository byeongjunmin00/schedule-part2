package com.example.schedulepart2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchedulePart2Application {

	public static void main(String[] args) {
		SpringApplication.run(SchedulePart2Application.class, args);
	}

}
