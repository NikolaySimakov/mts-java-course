package ru.mts.mtsjavacourse.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Pet extends AbstractAnimal {

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

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String info() {
        return String.format("Parent class: Pet\n%s", this.shortInfo());
    }

    @Override
    public Integer getAge() {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();
        int birthYear = this.birthDate.getYear();
        return nowYear - birthYear;
    }
}
