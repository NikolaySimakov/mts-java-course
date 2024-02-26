package ru.mts.mtsjavacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MtsJavaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtsJavaCourseApplication.class, args);
	}

}
