package ru.mts.mtsjavacourse.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mts.mtsjavacourse.exceptions.AnimalsListException;
import ru.mts.mtsjavacourse.exceptions.WrongAgeException;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.Animal;
import ru.mts.mtsjavacourse.services.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
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

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        return animalsMap.values().stream()
                .flatMap(List::stream)
                .filter(animal -> isLeapYear(animal.getBirthDate()))
                .collect(Collectors.toConcurrentMap(
                    animal -> animal.getClass().getSimpleName() + " " + animal.getName(),
                    Animal::getBirthDate,
                    (ex, repl) -> ex.isAfter(repl) ? ex : repl,
                    ConcurrentHashMap::new
                ));
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {
        if (animalsMap == null) {
            throw new IllegalArgumentException("animalsMap is null");
        }

        if (age < 0) {
            throw new WrongAgeException("Wrong age format: " + age);
        }

        Map<AbstractAnimal, Integer> olderAnimals = animalsMap.values().stream()
                .flatMap(List::stream)
                .filter(animal -> animal.getAge() > age)
                .collect(Collectors.toConcurrentMap(
                        animal -> animal,
                        Animal::getAge,
                        Integer::sum,
                        ConcurrentHashMap::new
                ));

        if (olderAnimals.isEmpty()) {
            System.out.println("No older animals found");
            AbstractAnimal oldestAnimal = findOldest(
                    animalsMap.values().stream()
                            .flatMap(List::stream)
                            .collect(Collectors.toCollection(CopyOnWriteArrayList::new))
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
                .collect(Collectors.groupingBy(
                        animal -> animal.getClass().getSimpleName(),
                        ConcurrentHashMap::new,
                        Collectors.toCollection(CopyOnWriteArrayList::new)
                ));
    }

    @Override
    public void printDuplicate() {
        Map<String, List<AbstractAnimal>> duplicates = findDuplicate();
        if (!duplicates.isEmpty()) {
            duplicates.forEach((className, animalsList) -> {
                System.out.println("Class: " + className);
                animalsList.forEach(animal -> System.out.println(animal.shortInfo()));
            });
        } else {
            System.out.println("No duplicates");
        }
    }

    @Override
    public double findAverageAge(List<AbstractAnimal> animalsList) {
        return animalsList
                .stream()
                .map(Animal::getBirthDate)
                .map(x -> Period.between(x, LocalDate.now()).getYears())
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
    }

    @Override
    public List<AbstractAnimal> findOldAndExpensive(List<AbstractAnimal> animalsList) {
        if (animalsList.isEmpty()) {
            return new ArrayList<>();
        }

        BigDecimal sum = animalsList.stream()
                .map(Animal::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal average = sum.divide(BigDecimal.valueOf(animalsList.size()), RoundingMode.HALF_UP);

        return animalsList
                .stream()
                .filter(animal -> animal.getCost().compareTo(average) > 0 && Period.between(
                                animal.getBirthDate(), LocalDate.now()).getYears() > 5
                )
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    @Override
    public List<AbstractAnimal> findMinConstAnimals(List<AbstractAnimal> animalsList) throws AnimalsListException {
        if (animalsList.size() < 3) {
            throw new AnimalsListException("List of animals contains less than 3 elements");
        }

        return animalsList
                .stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
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
}
