package com.charla.mandalorian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ConfigurationMandalorian.class})
public class MandalorianApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandalorianApplication.class, args);
	}

}
