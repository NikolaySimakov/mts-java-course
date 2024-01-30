package main.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private String dateFormatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    protected String info() {
        return "Parent class: Pet\n" +
                "- breed: " + this.getBreed() + '\n' +
                "- name: " + this.getName() + '\n' +
                "- cost: " + this.getCost() + '\n' +
                "- character: " + this.getCharacter() + '\n' +
                "- birthDate: " + dateFormatter(this.getBirthDate()) + '\n';
    }

}
