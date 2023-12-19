package services;

import models.animals.Shark;
import models.animals.Wolf;
import models.animals.Cat;
import models.animals.Dog;

import java.math.BigDecimal;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimalsN(int n) {

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    Wolf wolf = new Wolf("breed", "name", new BigDecimal(123), "character");
                    System.out.println(wolf.showInfo());
                    break;
                case 1:
                    Shark shark = new Shark("breed", "name", new BigDecimal(123), "character");
                    System.out.println(shark.showInfo());
                    break;
                case 2:
                    Cat cat = new Cat("breed", "name", new BigDecimal(123), "character");
                    System.out.println(cat.showInfo());
                    break;
                case 3:
                    Dog dog = new Dog("breed", "name", new BigDecimal(123), "character");
                    System.out.println(dog.showInfo());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void createAnimals() {
        int countOfAnimals = 0;
        Random random = new Random();

        do {

            switch (random.nextInt(4)) {
                case 0:
                    Wolf wolf = new Wolf("breed", "name", new BigDecimal(123), "character");
                    System.out.println(wolf.showInfo());
                    break;
                case 1:
                    Shark shark = new Shark("breed", "name", new BigDecimal(123), "character");
                    System.out.println(shark.showInfo());
                    break;
                case 2:
                    Cat cat = new Cat("breed", "name", new BigDecimal(123), "character");
                    System.out.println(cat.showInfo());
                    break;
                case 3:
                    Dog dog = new Dog("breed", "name", new BigDecimal(123), "character");
                    System.out.println(dog.showInfo());
                    break;
                default:
                    break;
            }

        } while (++countOfAnimals < 10);
    }
}
