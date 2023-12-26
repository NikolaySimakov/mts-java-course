package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {

    /**
     * Метод, возвращающий породу
     * @return String
     */
    String getBreed();

    /**
     * Метод, возвращающий имя
     * @return String
     */
    String getName();

    /**
     * Метод, возвращающий стоимость
     * @return BigDecimal
     */
    BigDecimal getCost();

    /**
     * Метод, возвращающий характер
     * @return String
     */
    String getCharacter();

    /**
     * Метод возвращающий дату рождения
     * @return LocalDate
     */
    LocalDate getBirthDate();
}
