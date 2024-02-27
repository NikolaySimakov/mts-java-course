package ru.mts.mtsjavacourse.repositories;

import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalsRepository {

    Map<String, LocalDate> findLeapYearNames();
    Map<AbstractAnimal, Integer> findOlderAnimal(int age);
    Map<String, Integer> findDuplicate();
    void printDuplicate();

}
