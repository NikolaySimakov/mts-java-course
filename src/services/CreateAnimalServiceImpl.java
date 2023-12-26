package services;

import models.AbstractAnimal;
import models.animals.Shark;
import models.animals.Wolf;
import models.animals.Cat;
import models.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public ArrayList<AbstractAnimal> createAnimalsN(int n) {
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        ArrayList<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();

        for (int i = 0; i < n; i++) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public ArrayList<AbstractAnimal> createAnimals() {
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        ArrayList<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        int countOfAnimals = 0;

        do {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
            animals.add(animal);
        } while (++countOfAnimals < 10);

        return animals;
    }
}
