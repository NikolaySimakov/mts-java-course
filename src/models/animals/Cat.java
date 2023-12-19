package models.animals;

import models.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cat extends Pet {

    public Cat(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    public String showInfo() {
        return "Class: Cat\n" + this.info();
    }
}
