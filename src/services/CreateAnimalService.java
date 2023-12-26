package services;

import models.AbstractAnimal;
import models.animals.Wolf;
import models.animals.Shark;
import models.animals.Cat;
import models.animals.Dog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;

public interface CreateAnimalService {

    default ArrayList<AbstractAnimal> createAnimals() {
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        ArrayList<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        int countOfAnimals = 0;

        while (countOfAnimals < 10) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed", "name", new BigDecimal("123.2124512"), "character", LocalDate.of(2000, 7, 28));
            animals.add(animal);
            countOfAnimals++;
        }

        return animals;
    }

}
