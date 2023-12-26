package services;

import models.AbstractAnimal;

import java.util.ArrayList;

public interface SearchService {

    ArrayList<String> findLeapYearNames(ArrayList<AbstractAnimal> animals);

    ArrayList<AbstractAnimal> findOlderAnimal(ArrayList<AbstractAnimal> animals, int n);

    ArrayList<AbstractAnimal> findDuplicate(ArrayList<AbstractAnimal> animals);
}
