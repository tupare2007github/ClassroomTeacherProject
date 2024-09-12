package com.tka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class ClassroomteacherprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassroomteacherprojectApplication.class, args);
	}

}
