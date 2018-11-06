package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This microservice allows us to retrieve, persist, and manipulate trainee and
 * trainer information. The microservice is discoverable by Eureka and is a Spring
 * Boot application.
 * 
 * @author Ben Nemec and Justin Donn
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages= {"com.revature.caliber"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
