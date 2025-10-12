package com.jio.mobiles_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MobilesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilesServiceApplication.class, args);
	}

}
