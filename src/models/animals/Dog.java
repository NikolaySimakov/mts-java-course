package models.animals;

import models.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dog extends Pet {

    public Dog(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    public String showInfo() {
        return "Class: Dog\n" + this.info();
    }
}
