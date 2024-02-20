package ru.mts.mtsjavacourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.mtsjavacourse.AnimalsData;
import ru.mts.mtsjavacourse.AnimalsData;
import ru.mts.mtsjavacourse.services.AnimalFactory;
import ru.mts.mtsjavacourse.services.CreateAnimalService;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class ConfigurationApp {

    @Autowired
    private AnimalsData animalsData;

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(new AnimalFactory());
    }

}
