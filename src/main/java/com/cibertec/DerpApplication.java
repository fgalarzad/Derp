package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DerpApplication.class, args);
	}

}
