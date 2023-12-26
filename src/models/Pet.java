package models;

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

    protected String info() {
        return "Parent class: Pet\n" +
                "- breed: " + this.getBreed() + '\n' +
                "- name: " + this.getName() + '\n' +
                "- cost: " + this.getCost() + '\n' +
                "- character: " + this.getCharacter() + '\n' +
                "- birthDate: " + this.getBirthDate() + '\n';
    }

}
