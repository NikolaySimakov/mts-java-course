package main.services;

import main.models.AbstractAnimal;
import main.models.animals.Wolf;
import main.models.animals.Shark;
import main.models.animals.Cat;
import main.models.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AnimalFactory {
    public AbstractAnimal createAnimal(int n, String breed, String name, BigDecimal weight, String character, LocalDate birthDate) {

        switch (n) {
            case 0:
                return new Wolf(breed, name, weight, character, birthDate);
            case 1:
                return new Shark(breed, name, weight, character, birthDate);
            case 2:
                return new Cat(breed, name, weight, character, birthDate);
            case 3:
                return new Dog(breed, name, weight, character, birthDate);
        }

        throw new IllegalArgumentException("Error animal");
    }
}