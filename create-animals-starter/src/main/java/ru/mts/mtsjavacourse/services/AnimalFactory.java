package ru.mts.mtsjavacourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Cat;
import ru.mts.mtsjavacourse.models.animals.Dog;
import ru.mts.mtsjavacourse.models.animals.Shark;
import ru.mts.mtsjavacourse.models.animals.Wolf;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Component
public class AnimalFactory {

    @Autowired
    private AnimalsProperties animalsProperties;

    public AbstractAnimal createAnimal(int n, String breed, BigDecimal weight, String character, LocalDate birthDate) {

        Random random = new Random();

        return switch (n) {
            case 0 -> new Wolf(breed, animalsProperties.getWolfNames()
                    .get(random.nextInt(animalsProperties.getWolfNames().size())), weight, character, birthDate);
            case 1 -> new Shark(breed, animalsProperties.getSharkNames()
                    .get(random.nextInt(animalsProperties.getSharkNames().size())), weight, character, birthDate);
            case 2 -> new Cat(breed, animalsProperties.getCatNames()
                    .get(random.nextInt(animalsProperties.getCatNames().size())), weight, character, birthDate);
            case 3 -> new Dog(breed, animalsProperties.getDogNames()
                    .get(random.nextInt(animalsProperties.getDogNames().size())), weight, character, birthDate);
            default -> throw new IllegalArgumentException("Error animal");
        };

    }
}