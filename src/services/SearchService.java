package services;

import models.AbstractAnimal;

import java.util.ArrayList;

public interface SearchService {

    ArrayList<String> findLeapYearNames(AbstractAnimal[] animals);

    ArrayList<AbstractAnimal> findOlderAnimal(AbstractAnimal[] animals, int n);

    ArrayList<AbstractAnimal> findDuplicate(AbstractAnimal[] animals);
}
