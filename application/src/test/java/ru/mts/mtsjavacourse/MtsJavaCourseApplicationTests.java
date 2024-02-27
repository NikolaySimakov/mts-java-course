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
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MtsJavaCourseApplication.class)
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
		Map<AbstractAnimal, Integer> animalsMap = animalsRepository.findOlderAnimal(3);
		int currentYear = LocalDate.now().getYear();

		for (AbstractAnimal animal : animalsMap.keySet()) {
			assertTrue(currentYear - animal.getBirthDate().getYear() >= 3);
		}
	}

	@Test
	@DisplayName("Find older animal negative test")
	public void findOlderAnimalNegativeTest() {
		Map<AbstractAnimal, Integer> animalsMap = animalsRepository.findOlderAnimal(6);
		int currentYear = LocalDate.now().getYear();

		for (AbstractAnimal animal : animalsMap.keySet()) {
			assertFalse(currentYear - animal.getBirthDate().getYear() < 6);
		}
	}

	@Test
	@DisplayName("Find leap year names positive test")
	public void findLeapYearNamesPositiveTest() {
		Map<String, LocalDate> namesMap = animalsRepository.findLeapYearNames();

		for (String fullName : namesMap.keySet()) {
			String name = fullName.split(" ")[1];
			assertTrue(
					animalsProperties.getCatNames().contains(name) ||
							animalsProperties.getDogNames().contains(name) ||
							animalsProperties.getSharkNames().contains(name) ||
							animalsProperties.getWolfNames().contains(name)
			);
		}
	}

	@Test
	@DisplayName("Find leap year names negative test")
	public void findLeapYearNamesNegativeTest() {
		Map<String, LocalDate> namesMap = animalsRepository.findLeapYearNames();

		for (String name : namesMap.keySet()) {
			assertTrue(
					!animalsProperties.getCatNames().contains(name) &&
							!animalsProperties.getDogNames().contains(name) &&
							!animalsProperties.getSharkNames().contains(name) &&
							!animalsProperties.getWolfNames().contains(name)
			);
		}
	}

}
