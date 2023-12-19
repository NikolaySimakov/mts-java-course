package models;

import java.math.BigDecimal;

public interface Animal {

    /**
     * Метод, возвращающий породу
     * @return String
     */
    public String getBreed();

    /**
     * Метод, возвращающий имя
     * @return String
     */
    public String getName();

    /**
     * Метод, возвращающий стоимость
     * @return BigDecimal
     */
    public BigDecimal getCost();

    /**
     * Метод, возвращающий характер
     * @return String
     */
    public String getCharacter();

}
