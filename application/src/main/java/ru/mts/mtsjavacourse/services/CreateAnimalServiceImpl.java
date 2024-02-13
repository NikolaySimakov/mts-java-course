package ru.mts.mtsjavacourse.services;

import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.Animal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CreateAnimalServiceImpl implements CreateAnimalService {

    public List<Animal> animals;

    private String getAnimalName(int i) {
        String[] names = {"Wolf", "Shark", "Cat", "Dog"};
        return names[i];
    }

    private LocalDate getBirthDate(int i) {
        return switch (i) {
            case 0 -> LocalDate.of(2010, 5, 24);
            case 1 -> LocalDate.of(2012, 1, 8);
            case 2 -> LocalDate.of(2016, 6, 20);
            case 3 -> LocalDate.of(2020, 7, 13);
            default -> LocalDate.now();
        };
    }

    @Override
    public List<AbstractAnimal> createAnimalsN(int n) {
        AnimalFactory animalFactory = new AnimalFactory();
        List<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", getAnimalName(randomValue), new BigDecimal("123.2124512"), "character", getBirthDate(randomValue));
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<AbstractAnimal> createAnimals() {
        AnimalFactory animalFactory = new AnimalFactory();
        List<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        Random random = new Random();
        int countOfAnimals = 0;

        do {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", getAnimalName(randomValue), new BigDecimal("123.2124512"), "character", getBirthDate(randomValue));
            animals.add(animal);
        } while (++countOfAnimals < 10);

        return animals;
    }
}
