package ru.mts.mtsjavacourse.models.animals;

import ru.mts.mtsjavacourse.models.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String className, String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.className = className;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public String showInfo() {
        return String.format("Class: Cat\n%s", this.info());
    }
}
