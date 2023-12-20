package services;

import models.animals.Shark;
import models.animals.Wolf;
import models.animals.Cat;
import models.animals.Dog;

import java.math.BigDecimal;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private void chooseRandomAnimal() {
        Random random = new Random();

        switch (random.nextInt(4)) {
            case 0:
                Wolf wolf = new Wolf("breed", "name", new BigDecimal("123.2124512"), "character");
                System.out.println(wolf.showInfo());
                break;
            case 1:
                Shark shark = new Shark("breed", "name", new BigDecimal("287.384727"), "character");
                System.out.println(shark.showInfo());
                break;
            case 2:
                Cat cat = new Cat("breed", "name", new BigDecimal("47839.12847987"), "character");
                System.out.println(cat.showInfo());
                break;
            case 3:
                Dog dog = new Dog("breed", "name", new BigDecimal("758.38749"), "character");
                System.out.println(dog.showInfo());
                break;
        }
    }

    public void createAnimalsN(int n) {
        for (int i = 0; i < n; i++) {
            this.chooseRandomAnimal();
        }
    }

    @Override
    public void createAnimals() {
        int countOfAnimals = 0;

        do {
            this.chooseRandomAnimal();
        } while (++countOfAnimals < 10);
    }
}
