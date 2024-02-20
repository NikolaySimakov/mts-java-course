package ru.mts.mtsjavacourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mts.mtsjavacourse.AnimalsData;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Wolf;
import ru.mts.mtsjavacourse.models.animals.Shark;
import ru.mts.mtsjavacourse.models.animals.Cat;
import ru.mts.mtsjavacourse.models.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Component
@Scope(value = "singleton")
public class AnimalFactory {

    @Autowired
    private AnimalsData animalsData;

    public AbstractAnimal createAnimal(int n, String breed, BigDecimal weight, String character, LocalDate birthDate) {

        Random random = new Random();
        int randomValue = random.nextInt(4);

        return switch (n) {
            case 0 -> new Wolf(breed, animalsData.getWolfNames().get(randomValue), weight, character, birthDate);
            case 1 -> new Shark(breed, animalsData.getSharkNames().get(randomValue), weight, character, birthDate);
            case 2 -> new Cat(breed, animalsData.getCatNames().get(randomValue), weight, character, birthDate);
            case 3 -> new Dog(breed, animalsData.getDogNames().get(randomValue), weight, character, birthDate);
            default -> throw new IllegalArgumentException("Error animal");
        };

    }
}