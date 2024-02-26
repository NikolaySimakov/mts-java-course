package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.mtsjavacourse.config.CreateAnimalsTestConfig;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;
import ru.mts.mtsjavacourse.services.CreateAnimalService;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = CreateAnimalsTestConfig.class)
@ActiveProfiles("test")
class CreateAnimalsStarterApplicationTests {

    @Autowired
    private AnimalsProperties animalsProperties;
    @Autowired
    private CreateAnimalService createAnimalService;

    @Test
    void contextLoads() {
        assertNotNull(animalsProperties);
        assertNotNull(createAnimalService);
    }


	@ParameterizedTest(name = "Test for indexes {arguments}")
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("Equals positive test")
	public void animalEqualsPositiveTest(int i) {
		AbstractAnimal animal1 = createAnimalService.createAnimal(i);
		AbstractAnimal animal2 = createAnimalService.createAnimal(i);

		assertSame(animal1.getClass(), animal2.getClass());
		assertNotSame(animal1, animal2);

	}

	@ParameterizedTest(name = "Test for indexes {arguments}")
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("Equals negative test")
	public void animalEqualsNegativeTest(int i) {
		AbstractAnimal animal1 = createAnimalService.createAnimal(i);
		AbstractAnimal animal2 = createAnimalService.createAnimal(i + 1);

		assertNotSame(animal1.getClass(), animal2.getClass());
		assertNotSame(animal1, animal2);

	}

	@ParameterizedTest(name = "Test for indexes {arguments}")
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("Names exists positive test")
	public void existingNamesTest(int i) {
		AbstractAnimal animal = createAnimalService.createAnimal(i);
		assertTrue(animalsProperties.getNamesByIndex(i).contains(animal.getName()));
	}

}