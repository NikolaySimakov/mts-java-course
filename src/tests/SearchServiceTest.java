package tests;

import main.models.AbstractAnimal;
import main.models.animals.Cat;
import main.models.animals.Dog;
import main.models.animals.Shark;
import main.models.animals.Wolf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Assertions;

import main.services.SearchService;
import main.services.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchServiceTest {

    public static SearchService searchService;

    @BeforeAll
    public static void setupService() {
        searchService = new SearchServiceImpl();
    }

    @Test
    public void findLeapYearNamesTest() {
        Dog dog = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                LocalDate.of(2020, 7, 13));
        Cat cat = new Cat("Cat", "cat", new BigDecimal("123.2124512"), "character",
                LocalDate.of(2016, 6, 20));
        Wolf wolf = new Wolf("Wolf", "wolf", new BigDecimal("2039.21245"), "character",
                LocalDate.of(2010, 5, 24));
        Shark shark = new Shark("Shark", "shark", new BigDecimal("321.111111"), "character",
                LocalDate.of(2012, 1, 8));

        List<AbstractAnimal> testAnimals = Arrays.asList(dog, cat, wolf, shark);
        List<String> expectedNames = Arrays.asList("dog", "cat", "shark");
        Assertions.assertEquals(expectedNames, searchService.findLeapYearNames(testAnimals));

    }

    @Test
    public void findOlderAnimalTest() {
        Dog dog = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                LocalDate.of(2020, 7, 13));
        Cat cat = new Cat("Cat", "dog", new BigDecimal("123.2124512"), "character",
                LocalDate.of(2016, 6, 20));
        Wolf wolf = new Wolf("Wolf", "wolf", new BigDecimal("2039.21245"), "character",
                LocalDate.of(2010, 5, 24));
        Shark shark = new Shark("Shark", "shark", new BigDecimal("321.111111"), "character",
                LocalDate.of(2012, 1, 8));

        List<AbstractAnimal> testAnimals = Arrays.asList(dog, cat, wolf, shark);
        List<AbstractAnimal> expectedAnimals = Arrays.asList(cat, wolf, shark);
        Assertions.assertEquals(expectedAnimals, searchService.findOlderAnimal(testAnimals, 5));

    }
}
