package services;

import models.AbstractAnimal;
import models.animals.Wolf;
import models.animals.Shark;
import models.animals.Cat;
import models.animals.Dog;

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