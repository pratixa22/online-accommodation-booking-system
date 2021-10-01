package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class ProjectBackendApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
