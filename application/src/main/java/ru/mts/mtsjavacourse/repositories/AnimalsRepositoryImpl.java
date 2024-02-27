package ru.mts.mtsjavacourse.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.services.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;


@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    private CreateAnimalService animalService;

    private Map<String, List<AbstractAnimal>> animalsMap;

    @PostConstruct
    private void initAnimals() {
        animalsMap = animalService.createAnimals();
    }

    private boolean isLeapYear(LocalDate date) {
        int year = date.getYear();
        return (year > 1584 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)));
    }

    private boolean isOlderThan(LocalDate date, int n) {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();
        int birthYear = date.getYear();

        return ((nowYear - birthYear) > n);
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Map<String, LocalDate> leapYearNames = new HashMap<>();

        for (String key : animalsMap.keySet()) {
            List<AbstractAnimal> animals = animalsMap.get(key);
            for (AbstractAnimal animal : animals) {
                if (isLeapYear(animal.getBirthDate())) {
                    leapYearNames.put(key + " " + animal.getName(), animal.getBirthDate());
                }
            }
        }

        return leapYearNames;
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Map<AbstractAnimal, Integer> olderAnimal = new HashMap<>();

        for (String key : animalsMap.keySet()) {
            List<AbstractAnimal> animals = animalsMap.get(key);
            for (AbstractAnimal animal : animals) {
                if (isOlderThan(animal.getBirthDate(), age)) {
                    olderAnimal.put(animal, animal.getAge());
                }
            }
        }

        return olderAnimal;
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Map<String, Integer> duplicates = new HashMap<>();

        for (String key : animalsMap.keySet()) {
            List<AbstractAnimal> animals = animalsMap.get(key);
            int duplicatesCount = (new ArrayList<>(new HashSet<>(animals))).size();
            if (duplicatesCount > 0) {
                duplicates.put(key, duplicatesCount);
            }
        }

        return duplicates;
    }

    @Override
    public void printDuplicate() {
        Map<String, Integer> duplicates = findDuplicate();
        if (!duplicates.isEmpty()) {
            System.out.println(duplicates);
        } else {
            System.out.println("No duplicates");
        }
    }
}
