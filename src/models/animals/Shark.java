package models.animals;

import models.Predator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Shark extends Predator {

    public Shark(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    public String showInfo() {
        return "Class: Shark\n" +
                "breed: " + this.getBreed() + '\n' +
                "name: " + this.getName() + '\n' +
                "cost: " + this.getCost() + '\n' +
                "character: " + this.getCharacter() + '\n';
    }
}