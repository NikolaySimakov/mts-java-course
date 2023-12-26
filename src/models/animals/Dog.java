package models.animals;

import models.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public String showInfo() {
        return "Class: Dog\n" + this.info();
    }
}
