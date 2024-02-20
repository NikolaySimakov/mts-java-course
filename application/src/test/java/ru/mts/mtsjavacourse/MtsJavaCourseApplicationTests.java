package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.mtsjavacourse.config.MtsJavaCourseApplicationTestConfig;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;
import ru.mts.mtsjavacourse.services.CreateAnimalService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MtsJavaCourseApplicationTestConfig.class)
@ActiveProfiles("test")
class MtsJavaCourseApplicationTests {

	@Autowired
	private AnimalsProperties animalsProperties;

	@Autowired
	private CreateAnimalService createAnimalService;

	@Autowired
	private AnimalsRepository animalsRepository;

	@Test
	void contextLoads() {
		assertNotNull(animalsProperties);
		assertNotNull(animalsRepository);
		assertNotNull(createAnimalService);
	}

	@Test
	@DisplayName("Find older animal positive test")
	public void findOlderAnimalPositiveTest() {
		List<AbstractAnimal> animals = animalsRepository.findOlderAnimal(3);
		int currentYear = LocalDate.now().getYear();

		animals.forEach(a -> assertTrue(currentYear - a.getBirthDate().getYear() >=  3));
	}

	@Test
	@DisplayName("Find older animal positive test")
	public void findOlderAnimalNegativeTest() {
		List<AbstractAnimal> animals = animalsRepository.findOlderAnimal(6);
		int currentYear = LocalDate.now().getYear();

		animals.forEach(a -> assertFalse(currentYear - a.getBirthDate().getYear() <  6));
	}

	@Test
	@DisplayName("Find leap year names positive test")
	public void findLeapYearNamesPositiveTest() {
		List<String> names = animalsRepository.findLeapYearNames();

		names.forEach(name -> assertTrue(
				animalsProperties.getCatNames().contains(name) ||
						animalsProperties.getDogNames().contains(name) ||
						animalsProperties.getSharkNames().contains(name) ||
						animalsProperties.getWolfNames().contains(name)
		));
	}

	@Test
	@DisplayName("Find leap year names negative test")
	public void findLeapYearNamesNegativeTest() {
		List<String> names = animalsRepository.findLeapYearNames();

		names.forEach(name -> assertFalse(
				!animalsProperties.getCatNames().contains(name) &&
						!animalsProperties.getDogNames().contains(name) &&
						!animalsProperties.getSharkNames().contains(name) &&
						!animalsProperties.getWolfNames().contains(name)
		));
	}

	@ParameterizedTest(name = "Test for indexes {arguments}")
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("Equals positive test")
	public void animalEqualsPositiveTest() {
		AbstractAnimal animal1 = createAnimalService.createAnimal(1);
		AbstractAnimal animal2 = createAnimalService.createAnimal(1);

		assertSame(animal1.getClass(), animal2.getClass());
		assertNotSame(animal1, animal2);

	}

	@ParameterizedTest(name = "Test for indexes {arguments}")
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("Equals negative test")
	public void animalEqualsNegativeTest() {
		AbstractAnimal animal1 = createAnimalService.createAnimal(1);
		AbstractAnimal animal2 = createAnimalService.createAnimal(2);

		assertNotSame(animal1.getClass(), animal2.getClass());
		assertNotSame(animal1, animal2);

	}

}
