package app.repositories;

import app.models.AbstractAnimal;
import app.models.Animal;

import java.util.List;
import java.util.Set;

public interface AnimalsRepository {

    List<String> findLeapYearNames();
    List<AbstractAnimal> findOlderAnimal(int age);
    Set<AbstractAnimal> findDuplicate();
    void printDuplicate();

}
