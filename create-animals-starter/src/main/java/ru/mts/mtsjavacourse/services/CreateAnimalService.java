package ru.mts.mtsjavacourse.services;

import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface CreateAnimalService {

    AbstractAnimal createAnimal(int i);

    default Map<String, List<AbstractAnimal>> createAnimals() {
        Map<String, List<AbstractAnimal>> animalsMap = new ConcurrentHashMap<>();
        AnimalFactory animalFactory = new AnimalFactory();
        Random random = new Random();
        int countOfAnimals = 0;

        while (countOfAnimals < 10) {
            int randomValue = random.nextInt(4);
            AbstractAnimal animal = animalFactory.createAnimal(randomValue, "breed",
                    new BigDecimal("123.2124512"), "character",
                    LocalDate.of(2000, 7, 28));

            // saving to hashmap
            String key = animal.getClass().getSimpleName();
            if (animalsMap.containsKey(key)) {
                animalsMap.get(key).add(animal);
            } else {
                List<AbstractAnimal> animalList = new CopyOnWriteArrayList<>();
                animalList.add(animal);
                animalsMap.put(key, animalList);
            }

            countOfAnimals++;
        }

        return animalsMap;
    }

    Map<String, List<AbstractAnimal>> createAnimalsN(int n);
}
