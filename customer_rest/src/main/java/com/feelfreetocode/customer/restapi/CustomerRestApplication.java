package com.feelfreetocode.customer.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRestApplication.class, args);
	}

}
