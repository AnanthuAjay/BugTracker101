package com.bug.bg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BugServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugServiceApplication.class, args);
	}

}
