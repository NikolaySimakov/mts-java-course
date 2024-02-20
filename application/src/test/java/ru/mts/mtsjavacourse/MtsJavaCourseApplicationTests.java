package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	}

	@Test
	@DisplayName("Find older animal positive test")
	public void findOlderAnimalNegativeTest() {

	}

	@Test
	public void findLeapYearNamesTest() {
		List<String> names = animalsRepository.findLeapYearNames();
		for (String name : names) {
			assertTrue(
					animalsProperties.getCatNames().contains(name) ||
							animalsProperties.getDogNames().contains(name) ||
							animalsProperties.getSharkNames().contains(name) ||
							animalsProperties.getWolfNames().contains(name)
			);
		}
	}

}
