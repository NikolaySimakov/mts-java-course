package ru.mts.mtsjavacourse.repositories;

import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.Animal;

import java.util.List;
import java.util.Set;

public interface AnimalsRepository {

    List<String> findLeapYearNames();
    List<AbstractAnimal> findOlderAnimal(int age);
    Set<AbstractAnimal> findDuplicate();
    void printDuplicate();

}
