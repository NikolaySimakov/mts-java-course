package main.services;

import main.models.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public List<AbstractAnimal> createAnimalsN(int n) {
        AnimalFactory animalFactory = new AnimalFactory();
        List<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
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
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
            animals.add(animal);
        } while (++countOfAnimals < 10);

        return animals;
    }
}
