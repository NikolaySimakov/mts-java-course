package app.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    protected String breed; // погода
    protected String name; // имя
    protected BigDecimal cost; // цена в магазине должна быть округлена до 2 знаков после запятой
    protected String character; // характер
    protected LocalDate birthDate; // дата рождения

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
}
