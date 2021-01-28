package com.feelfreetocode.product.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRestApplication.class, args);
	}

}
