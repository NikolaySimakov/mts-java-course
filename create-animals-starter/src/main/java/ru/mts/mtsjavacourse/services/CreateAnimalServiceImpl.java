package ru.mts.mtsjavacourse.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.mtsjavacourse.models.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private final AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
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
    public AbstractAnimal createAnimal(int i) {
        return animalFactory.createAnimal(i, "breed", new BigDecimal("123.2124512"),
                "character", getBirthDate(i));
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimalsN(int n) {
        Map<String, List<AbstractAnimal>> animalsMap = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            // creating animal
            AbstractAnimal animal = animalFactory.createAnimal(random.nextInt(4), "breed",
                    new BigDecimal("123.2124512"), "character", getBirthDate(random.nextInt(4)));

            // saving to hashmap
            String key = animal.getClass().getSimpleName();
            if (animalsMap.containsKey(key)) {
                animalsMap.get(key).add(animal);
            } else {
                animalsMap.put(key, new ArrayList<AbstractAnimal>());
            }
        }
        return animalsMap;
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimals() {
        Map<String, List<AbstractAnimal>> animalsMap = new HashMap<>();
        Random random = new Random();
        int countOfAnimals = 0;

        do {
            // creating animal
            AbstractAnimal animal = animalFactory.createAnimal(random.nextInt(4), "breed",
                    new BigDecimal("123.2124512"), "character", getBirthDate(random.nextInt(4)));

            // saving to hashmap
            String key = animal.getClass().getSimpleName();
            if (animalsMap.containsKey(key)) {
                animalsMap.get(key).add(animal);
            } else {
                animalsMap.put(key, new ArrayList<AbstractAnimal>());
            }

        } while (++countOfAnimals < 20);

        return animalsMap;
    }
}
