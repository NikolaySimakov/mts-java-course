package ru.mts.mtsjavacourse.models.animals;

import ru.mts.mtsjavacourse.models.Predator;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {

    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public String showInfo() {
        return String.format("Class: Wolf\n%s", this.info());
    }
}
