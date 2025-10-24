package com.eazybytes.eazystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.eazybytes.eazystore.controller"}) //optional
public class EazystoreApplication {

    /*
    When you are defining all your java classes, which are supposed to be created as the beans
    by the spring framework under the same package where your Spring Boot main class is present,
    then there is no need of mentioning @ComponentScan on top of your Spring Boot main class
     */

	public static void main(String[] args) {
		SpringApplication.run(EazystoreApplication.class, args);
	}

}
