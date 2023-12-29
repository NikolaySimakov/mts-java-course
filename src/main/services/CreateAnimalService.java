package main.services;

import main.models.AbstractAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;

public interface CreateAnimalService {

    default List<AbstractAnimal> createAnimals() {
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        List<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        int countOfAnimals = 0;

        while (countOfAnimals < 10) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
            animals.add(animal);
            countOfAnimals++;
        }

        return animals;
    }

    List<AbstractAnimal> createAnimalsN(int n);
}