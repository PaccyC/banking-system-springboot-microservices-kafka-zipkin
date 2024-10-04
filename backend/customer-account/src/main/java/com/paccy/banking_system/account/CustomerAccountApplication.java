package com.paccy.banking_system.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountApplication.class, args);
	}

}
