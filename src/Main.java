import models.AbstractAnimal;
import models.animals.Cat;
import models.animals.Wolf;
import services.CreateAnimalServiceImpl;
import services.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CreateAnimalServiceImpl animalServiceImpl = new CreateAnimalServiceImpl();
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();

        // create 10 animals
        ArrayList<AbstractAnimal> animals1 = animalServiceImpl.createAnimals();

        // create N animals
        int n = 4;
        ArrayList<AbstractAnimal> animals2 = animalServiceImpl.createAnimalsN(n);


        System.out.println(searchServiceImpl.findLeapYearNames(animals1));
        System.out.println(searchServiceImpl.findOlderAnimal(animals1, 24));
        System.out.println(searchServiceImpl.findDuplicate(animals1));

        System.out.println(searchServiceImpl.findLeapYearNames(animals2));
        System.out.println(searchServiceImpl.findOlderAnimal(animals1, 20));
    }
}
