package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Predator extends AbstractAnimal {

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

    protected String info() {
        return "Parent class: Predator\n" +
                "- breed: " + this.getBreed() + '\n' +
                "- name: " + this.getName() + '\n' +
                "- cost: " + this.getCost() + '\n' +
                "- character: " + this.getCharacter() + '\n';
    }
}
