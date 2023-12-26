package services;

import models.AbstractAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class SearchServiceImpl implements SearchService {

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
    public ArrayList<String> findLeapYearNames(ArrayList<AbstractAnimal> animals) {
        ArrayList<String> names = new ArrayList<String>();

        for (AbstractAnimal animal : animals) {
            if (isLeapYear(animal.getBirthDate())) {
                names.add(animal.getName());
            }
        }

        return names;
    }

    @Override
    public ArrayList<AbstractAnimal> findOlderAnimal(ArrayList<AbstractAnimal> animals, int n) {
        ArrayList<AbstractAnimal> res = new ArrayList<AbstractAnimal>();

        for (AbstractAnimal animal : animals) {
            if (isOlderThan(animal.getBirthDate(), n)) {
                res.add(animal);
            }
        }

        return res;
    }

    @Override
    public ArrayList<AbstractAnimal> findDuplicate(ArrayList<AbstractAnimal> animals) {
        ArrayList<AbstractAnimal> res = new ArrayList<AbstractAnimal>();

        for (int i = 0; i < animals.size(); i++) {
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(i).equals(animals.get(j))) {
                    res.add(animals.get(i));
                }
            }
        }

        return res;
    }
}
