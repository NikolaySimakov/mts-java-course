package main;

import main.models.AbstractAnimal;
import main.services.CreateAnimalService;
import main.services.CreateAnimalServiceImpl;
import main.services.SearchService;
import main.services.SearchServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CreateAnimalService animalServiceImpl = new CreateAnimalServiceImpl();
        SearchService searchServiceImpl = new SearchServiceImpl();

        // create 10 animals
        List<AbstractAnimal> animals1 = animalServiceImpl.createAnimals();

        // create N animals
        int n = 4;
        List<AbstractAnimal> animals2 = animalServiceImpl.createAnimalsN(n);


        System.out.println(searchServiceImpl.findLeapYearNames(animals1));
        System.out.println(searchServiceImpl.findOlderAnimal(animals1, 5));
        System.out.println(searchServiceImpl.findDuplicate(animals1));

        System.out.println(searchServiceImpl.findLeapYearNames(animals2));
        System.out.println(searchServiceImpl.findOlderAnimal(animals1, 5));
    }
}
