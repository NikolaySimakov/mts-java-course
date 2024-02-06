package app.services;

import app.models.AbstractAnimal;
import app.models.animals.Wolf;
import app.models.animals.Shark;
import app.models.animals.Cat;
import app.models.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;

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