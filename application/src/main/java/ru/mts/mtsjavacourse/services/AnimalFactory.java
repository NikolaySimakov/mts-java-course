package ru.mts.mtsjavacourse.services;

import org.springframework.stereotype.Service;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Wolf;
import ru.mts.mtsjavacourse.models.animals.Shark;
import ru.mts.mtsjavacourse.models.animals.Cat;
import ru.mts.mtsjavacourse.models.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AnimalFactory {

    public AbstractAnimal createAnimal(int n, String breed, String name, BigDecimal weight, String character, LocalDate birthDate) {

        return switch (n) {
            case 0 -> new Wolf(breed, name, weight, character, birthDate);
            case 1 -> new Shark(breed, name, weight, character, birthDate);
            case 2 -> new Cat(breed, name, weight, character, birthDate);
            case 3 -> new Dog(breed, name, weight, character, birthDate);
            default -> throw new IllegalArgumentException("Error animal");
        };

    }
}