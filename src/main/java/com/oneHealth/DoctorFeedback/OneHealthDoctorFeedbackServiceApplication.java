package com.oneHealth.DoctorFeedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OneHealthDoctorFeedbackServiceApplication {

	public static void main(String[] args) {
		// This is the main entry point of the application.
		// It is called when the application is started and initializes the Spring Boot application.
		SpringApplication.run(OneHealthDoctorFeedbackServiceApplication.class, args);
	}
	
	@GetMapping
	public String getMessage()
	{
		return "OneHealth - Doctor Feedback Service";
				
	}
}
