package models.animals;

import models.Predator;
import java.math.BigDecimal;

public class Wolf extends Predator {

    public Wolf(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    public String showInfo() {
        return "Class: Wolf\n" + this.info();
    }
}
