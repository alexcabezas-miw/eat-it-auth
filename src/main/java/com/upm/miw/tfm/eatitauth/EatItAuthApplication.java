package com.upm.miw.tfm.eatitauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EatItAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatItAuthApplication.class, args);
	}

}
