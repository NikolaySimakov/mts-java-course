package ru.mts.mtsjavacourse.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mts.mtsjavacourse.services.AnimalFactory;
import ru.mts.mtsjavacourse.services.CreateAnimalService;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;


@TestConfiguration
public class MtsJavaCourseApplicationTestConfig {

    @Bean
    public CreateAnimalService createAnimalService(AnimalFactory animalFactory) {
        return new CreateAnimalServiceImpl(animalFactory);
    }

}