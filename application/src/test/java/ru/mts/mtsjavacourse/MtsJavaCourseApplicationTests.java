package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MtsJavaCourseApplicationTests {

	@Autowired
	private AnimalsProperties animalsProperties;
	@Autowired
	private AnimalsRepository animalsRepository;

	@Test
	void contextLoads() {
		assertNotNull(animalsProperties);
		assertNotNull(animalsRepository);
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

}
