package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Cat;
import ru.mts.mtsjavacourse.properties.AnimalsProperties;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
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

	@Test
	@DisplayName("Find average age test")
	public void testFindAverageAge() {
		List<LocalDate> birthDates = new ArrayList<>(List.of(
				LocalDate.of(2016, 7, 12),
				LocalDate.of(2014, 10, 6),
				LocalDate.of(2018, 12, 9),
				LocalDate.of(2017, 9, 5)
		));

		List<AbstractAnimal> cats = new ArrayList<>();
		double expected = 0;

        for (LocalDate birthDate : birthDates) {
            cats.add(new Cat("breed", "name", new BigDecimal("1.123"), "character", birthDate));
            expected += Period.between(birthDate, LocalDate.now()).getYears();
        }

		expected = expected / cats.size();
		double actualAverageAge = animalsRepository.findAverageAge(cats);
		assertEquals(actualAverageAge, expected);
	}

	@Test
	@DisplayName("Find old and expensive")
	public void testFindOldAndExpensive() {
		List<AbstractAnimal> cats = new ArrayList<>();
		cats.add(new Cat("breed", "name", new BigDecimal("1.123"), "character",
				LocalDate.of(2016, 7, 12)));
		cats.add(new Cat("breed", "name", new BigDecimal("1"), "character",
				LocalDate.of(2016, 3, 23)));
		cats.add(new Cat("breed", "name", new BigDecimal("1"), "character",
				LocalDate.of(2020, 9, 12)));
		cats.add(new Cat("breed", "name", new BigDecimal("0.9837"), "character",
				LocalDate.of(2021, 1, 1)));
		cats.add(new Cat("breed", "name", new BigDecimal("0.8"), "character",
				LocalDate.of(2022, 6, 1)));

		List<AbstractAnimal> expectedCats = new ArrayList<>(List.of(
				new Cat("breed", "name", new BigDecimal("1"), "character",
						LocalDate.of(2016, 3, 23)),
				new Cat("breed", "name", new BigDecimal("1.123"), "character",
						LocalDate.of(2016, 7, 12))
		));

		List<AbstractAnimal> actualCats = animalsRepository.findOldAndExpensive(cats);

		assertNotNull(actualCats);
		assertEquals(actualCats, expectedCats);
	}

	@Test
	@DisplayName("Find min cost animals")
	public void testFindMinCostAnimals() {
		List<AbstractAnimal> cats = new ArrayList<>();
		cats.add(new Cat("breed1", "A", new BigDecimal("1.2"), "character",
				LocalDate.of(2016, 7, 12)));
		cats.add(new Cat("breed2", "B", new BigDecimal("1.1"), "character",
				LocalDate.of(2016, 3, 23)));
		cats.add(new Cat("breed3", "C", new BigDecimal("1"), "character",
				LocalDate.of(2020, 9, 12)));
		cats.add(new Cat("breed4", "D", new BigDecimal("0.9837"), "character",
				LocalDate.of(2021, 1, 1)));
		cats.add(new Cat("breed5", "E", new BigDecimal("0.8"), "character",
				LocalDate.of(2022, 6, 1)));

		List<AbstractAnimal> actualCats = animalsRepository.findMinConstAnimals(cats);

		List<AbstractAnimal> expectedCats = new ArrayList<>(List.of(
				new Cat("breed5", "E", new BigDecimal("0.8"), "character",
						LocalDate.of(2022, 6, 1)),
				new Cat("breed4", "D", new BigDecimal("0.9837"), "character",
						LocalDate.of(2021, 1, 1)),
				new Cat("breed3", "C", new BigDecimal("1"), "character",
						LocalDate.of(2020, 9, 12))
		));

		assertNotNull(actualCats);
		assertEquals(actualCats, expectedCats);
	}

}
