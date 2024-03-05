package ru.mts.mtsjavacourse.repositories;

import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalsRepository {

    Map<String, List<AbstractAnimal>> getAnimals();
    Map<String, LocalDate> findLeapYearNames();
    Map<AbstractAnimal, Integer> findOlderAnimal(int age);
    Map<String, List<AbstractAnimal>> findDuplicate();
    void printDuplicate();

}
