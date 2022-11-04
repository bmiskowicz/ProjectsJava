package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApiApplication.class, args);
		System.out.println("http://localhost:8080/swagger.html");
	}

}
