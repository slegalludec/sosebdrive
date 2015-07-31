package com.soseb.drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class MainLauncher {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainLauncher.class, args);
	}
	
}
