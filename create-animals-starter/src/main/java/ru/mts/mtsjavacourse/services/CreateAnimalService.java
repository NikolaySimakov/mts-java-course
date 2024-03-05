package ru.mts.mtsjavacourse.services;

import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public interface CreateAnimalService {

    AbstractAnimal createAnimal(int i);

    default Map<String, List<AbstractAnimal>> createAnimals() {
        Map<String, List<AbstractAnimal>> animalsMap = new HashMap<>();
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        int countOfAnimals = 0;

        while (countOfAnimals < 10) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed",
                    new BigDecimal("123.2124512"), "character",
                    LocalDate.of(2000, 7, 28));

            // saving to hashmap
            String key = animal.getClassName();
            if (animalsMap.containsKey(key)) {
                animalsMap.get(key).add(animal);
            } else {
                animalsMap.put(key, new ArrayList<AbstractAnimal>());
            }

            countOfAnimals++;
        }

        return animalsMap;
    }

    Map<String, List<AbstractAnimal>> createAnimalsN(int n);
}
