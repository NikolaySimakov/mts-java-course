package ru.mts.mtsjavacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class MtsJavaCourseApplication {

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(MtsJavaCourseApplication.class);
//
//		CreateAnimalService animalServiceImpl = context.getBean(CreateAnimalService.class);
//		AnimalsRepository animalsRepository = context.getBean(AnimalsRepository.class);
//
////        int n = 4;
////        animalServiceImpl.createAnimalsN(n);
//
//		System.out.println();
//		System.out.println("--------findLeapYearNames--------");
//		System.out.println();
//		System.out.println(animalsRepository.findLeapYearNames());
//		System.out.println();
//		System.out.println("--------findOlderAnimal--------");
//		System.out.println();
//		for (AbstractAnimal animal : animalsRepository.findOlderAnimal(5)) {
//			System.out.println(animal.shortInfo());
//		}
//		System.out.println();
//		System.out.println("--------printDuplicate-------");
//		System.out.println();
//		animalsRepository.printDuplicate();

		SpringApplication.run(MtsJavaCourseApplication.class, args);
	}

}
