package app.repositories;

import app.models.AbstractAnimal;
import app.models.Animal;
import app.services.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    private CreateAnimalService animalService;

    private List<AbstractAnimal> animals;

    @PostConstruct
    private void initAnimals() {
        animals = animalService.createAnimals();
    }

    private boolean isLeapYear(LocalDate date) {
        int year = date.getYear();
        return (year > 1584 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)));
    }

    private boolean isOlderThan(LocalDate date, int n) {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();
        int birthYear = date.getYear();

        return ((nowYear - birthYear) > n);
    }

    @Override
    public List<String> findLeapYearNames() {
        List<String> names = new ArrayList<String>();

        for (AbstractAnimal animal : animals) {
            if (isLeapYear(animal.getBirthDate())) {
                names.add(animal.getName());
            }
        }

        return names;
    }

    @Override
    public List<AbstractAnimal> findOlderAnimal(int age) {
        List<AbstractAnimal> res = new ArrayList<AbstractAnimal>();

        for (AbstractAnimal animal : animals) {
            if (isOlderThan(animal.getBirthDate(), age)) {
                res.add(animal);
            }
        }

        return res;
    }

    @Override
    public Set<AbstractAnimal> findDuplicate() {
        List<AbstractAnimal> res = new ArrayList<AbstractAnimal>();

        for (int i = 0; i < animals.size(); i++) {
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(i).equals(animals.get(j)) && !res.contains(animals.get(i)) && !res.contains(animals.get(j))) {
                    res.add(animals.get(i));
                }
            }
        }

        return new HashSet<>(res);
    }

    @Override
    public void printDuplicate() {
        for (AbstractAnimal animal : findDuplicate()) {
            System.out.println(animal.shortInfo());
        }
    }
}
