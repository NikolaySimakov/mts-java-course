package ru.mts.mtsjavacourse.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAnimal implements Animal {

    protected String breed; // погода
    protected String name; // имя
    protected BigDecimal cost; // цена в магазине должна быть округлена до 2 знаков после запятой
    protected String character; // характер
    protected LocalDate birthDate; // дата рождения

    private String dateFormatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractAnimal other)) {
            return false;
        }
        return breed.equals(other.breed) &&
                name.equals(other.name) &&
                cost.equals(other.cost) &&
                character.equals(other.character) &&
                birthDate.equals(other.birthDate);
    }

    @Override
    public int hashCode() {
        int res = getBreed().hashCode();
        res = 40 * res + getName().hashCode();
        res = 40 * res + getCost().hashCode();
        res = 40 * res + getCharacter().hashCode();
        res = 40 * res + getBirthDate().hashCode();
        return res;
    }

    public String shortInfo() {
        return "- class: " + this.getClassName() + '\n' +
                "- breed: " + this.getBreed() + '\n' +
                "- name: " + this.getName() + '\n' +
                "- cost: " + this.getCost() + '\n' +
                "- character: " + this.getCharacter() + '\n' +
                "- birthDate: " + dateFormatter(this.getBirthDate()) + '\n';
    }
}

