package com.fleetapp.fleetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")//tell SpringBoot name of the Bean
public class FleetappApplication {
	

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();//returns name of currently logged in user
	}

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	}

}
