package app;

import app.models.AbstractAnimal;
import app.models.animals.Cat;
import app.models.animals.Dog;
import app.models.animals.Shark;
import app.models.animals.Wolf;
import org.junit.jupiter.api.*;

import app.services.SearchService;
import app.services.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


@MockitoSettings(strictness = Strictness.LENIENT)
public class SearchServiceTest {

    public static SearchService searchService;

    @BeforeAll
    public static void setupService() {
        searchService = new SearchServiceImpl();
    }

    @Nested
    public class EqualsMethodTest {
        @Test
        @DisplayName("Test equal animals")
        public void testEqualAnimals() {
            Dog dog1 = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                    LocalDate.of(2020, 7, 13));
            Dog dog2 = new Dog("Dog", "dog", new BigDecimal("13.213"), "character",
                    LocalDate.of(2020, 7, 13));

            assertTrue(dog1.equals(dog2));
        }

        @Test
        @DisplayName("Test unequal animals")
        public void testUnequalAnimals() {
            Dog dog1 = new Dog("Dog1", "dog1", new BigDecimal("11.213"), "char",
                    LocalDate.of(2022, 7, 13));
            Dog dog2 = new Dog("Dog2", "dog2", new BigDecimal("13.213"), "character",
                    LocalDate.of(2020, 7, 13));

            assertFalse(dog1.equals(dog2));
        }
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
            List<AbstractAnimal> duplicates = searchService.findDuplicate(testAnimals);

            Assertions.assertEquals(2, duplicates.size());
            Assertions.assertEquals(expectedAnimals, duplicates);
        }
    }
}