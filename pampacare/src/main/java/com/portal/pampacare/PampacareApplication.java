package com.portal.pampacare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.portal.controller","com.portal.service"})
@EntityScan("com.portal.entity")
@EnableJpaRepositories("com.portal.repository")
public class PampacareApplication {

	public static void main(String[] args) {
		SpringApplication.run(PampacareApplication.class, args);
	}

}
