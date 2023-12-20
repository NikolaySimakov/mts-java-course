package models;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal {
    protected String breed; // погода
    protected String name; // имя
    protected BigDecimal cost; // цена в магазине должна быть округлена до 2 знаков после запятой
    protected String character; // характер

}
