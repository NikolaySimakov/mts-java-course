package ru.mts.mtsjavacourse.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.Animal;
import ru.mts.mtsjavacourse.services.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    private CreateAnimalService animalService;

    private Map<String, List<AbstractAnimal>> animalsMap;

    @PostConstruct
    private void initAnimals() {
        animalsMap = animalService.createAnimals();
    }

    public Map<String, List<AbstractAnimal>> getAnimals() {
        return animalsMap;
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

    private AbstractAnimal findOldest(List<AbstractAnimal> animalList) {
        return animalList.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Map<String, LocalDate> leapYearNames = new HashMap<>();

        animalsMap.forEach((key, value) -> value
                .stream()
                .filter(animal -> isLeapYear(animal.getBirthDate()))
                .forEach(a -> leapYearNames.put(
                                key.concat(" ".concat(a.getName())), a.getBirthDate()
                        )
                ));

        return leapYearNames;
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Map<AbstractAnimal, Integer> olderAnimals = animalsMap.values().stream()
                .flatMap(List::stream)
                .filter(animal -> animal.getAge() > age)
                .collect(Collectors.toMap(
                        animal -> animal,
                        Animal::getAge,
                        Integer::sum
                ));

        if (olderAnimals.isEmpty()) {
            System.out.println("No older animals found");
            AbstractAnimal oldestAnimal = findOldest(
                    animalsMap.values().stream()
                            .flatMap(List::stream)
                            .collect(Collectors.toList())
            );

            int oldestAnimalAge = oldestAnimal.getAge();
            olderAnimals.put(oldestAnimal, oldestAnimalAge);
        }

        return olderAnimals;
    }

    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate() {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        Set<AbstractAnimal> animalsSet = new HashSet<>();

        return animalsMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(animal -> !animalsSet.add(animal))
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName(), Collectors.toList()));
    }

    @Override
    public void printDuplicate() {
        Map<String, List<AbstractAnimal>> duplicates = findDuplicate();
        if (!duplicates.isEmpty()) {
            duplicates.forEach((className, animalsList) -> {
                System.out.println("Class: " + className);
                animalsList.forEach(animal -> System.out.println(animal.toString()));
            });
        } else {
            System.out.println("No duplicates");
        }
    }
}
