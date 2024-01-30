package tests;

import main.models.AbstractAnimal;
import main.models.animals.Cat;
import main.models.animals.Dog;
import main.models.animals.Shark;
import main.models.animals.Wolf;
import org.junit.jupiter.api.*;

import main.services.SearchService;
import main.services.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SearchServiceTest {

    public static SearchService searchService;

    @BeforeAll
    public static void setupService() {
        searchService = new SearchServiceImpl();
    }

    @Nested
    public class EqualsMethodTest {

    }

    @Nested
    public class BaseMethodsTests {

        @Test
        @DisplayName("Find leap year names test")
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

        @ParameterizedTest(name = "Test for older than {arguments}")
        @ValueSource(ints = {4, 6, 7})
        @DisplayName("Find older animal test")
        public void findOlderAnimalTest(int N) {
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
            Assertions.assertEquals(expectedAnimals, searchService.findOlderAnimal(testAnimals, N));
        }

        @Test
        @DisplayName("Find duplicate test")
        public void findDuplicateTest() {
            Dog dog1 = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                    LocalDate.of(2020, 7, 13));
            Dog dog2 = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                    LocalDate.of(2020, 7, 13));
            Cat cat1 = new Cat("Cat", "cat", new BigDecimal("123.2124512"), "character",
                    LocalDate.of(2015, 6, 20));
            Cat cat2 = new Cat("Cat", "cat", new BigDecimal("123.2124512"), "character",
                    LocalDate.of(2015, 6, 20));
            Wolf wolf = new Wolf("Wolf", "wolf", new BigDecimal("2039.21245"), "character",
                    LocalDate.of(2010, 5, 24));
            Shark shark = new Shark("Shark", "shark", new BigDecimal("321.111111"), "character",
                    LocalDate.of(2012, 1, 8));

            List<AbstractAnimal> testAnimals = Arrays.asList(dog1, dog2, cat1, cat2, wolf, shark);
            List<AbstractAnimal> expectedAnimals = Arrays.asList(dog1, cat1);
            Assertions.assertEquals(expectedAnimals, searchService.findDuplicate(testAnimals));
        }
    }
}
