package ru.mts.mtsjavacourse.models.animals;

import ru.mts.mtsjavacourse.models.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shark extends Predator {

    public Shark(String className, String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.className = className;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public String showInfo() {
        return String.format("Class: Shark\n%s", this.info());
    }
}
