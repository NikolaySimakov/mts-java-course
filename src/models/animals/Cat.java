package models.animals;

import models.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public String showInfo() {
        return "Class: Cat\n" + this.info();
    }
}
