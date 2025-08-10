package com.cdac.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cdac.controller","com.cdac.service"})
@EntityScan(basePackages = {"com.cdac.entity"})
@EnableJpaRepositories(basePackages = {"com.cdac.repository"})
public class SpringBoot{

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}