package ru.mts.mtsjavacourse.services;

import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.util.List;

public interface SearchService {

    List<String> findLeapYearNames(List<AbstractAnimal> animals);

    List<AbstractAnimal> findOlderAnimal(List<AbstractAnimal> animals, int n);

    List<AbstractAnimal> findDuplicate(List<AbstractAnimal> animals);
}
