package com.challange.InsuranceSimulator_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InsuranceSimulatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSimulatorApiApplication.class, args);
	}

}
