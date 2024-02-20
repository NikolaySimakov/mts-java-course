package ru.mts.mtsjavacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.Animal;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;
import ru.mts.mtsjavacourse.services.CreateAnimalService;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class MtsJavaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtsJavaCourseApplication.class, args);
	}

}
