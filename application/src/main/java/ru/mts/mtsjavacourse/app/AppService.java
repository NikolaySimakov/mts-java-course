package ru.mts.mtsjavacourse.app;

import ru.mts.mtsjavacourse.AnimalsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;
import ru.mts.mtsjavacourse.repositories.AnimalsRepositoryImpl;
import ru.mts.mtsjavacourse.services.AnimalFactory;
import ru.mts.mtsjavacourse.services.CreateAnimalService;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppService {

//
    @Autowired
    private AnimalsData animalsData;
//
//    //    @Autowired
////    private AnimalsRepository animalsRepositoryImpl;
//
    @PostConstruct
    public void init() {
        System.out.println(animalsData.getConfig());
    }
//
//    public void searchAnimals() {
//
////        animalServiceImpl.setGreeter(greeter);
//
////        int n = 4;
////        animalServiceImpl.createAnimalsN(n);
//
//        AnimalsRepository animalsRepositoryImpl = new AnimalsRepositoryImpl();
//
//		System.out.println();
//		System.out.println("--------findLeapYearNames--------");
//		System.out.println();
//		System.out.println(animalsRepositoryImpl.findLeapYearNames());
//		System.out.println();
//		System.out.println("--------findOlderAnimal--------");
//		System.out.println();
//		for (AbstractAnimal animal : animalsRepositoryImpl.findOlderAnimal(5)) {
//			System.out.println(animal.shortInfo());
//		}
//		System.out.println();
//		System.out.println("--------printDuplicate-------");
//		System.out.println();
//        animalsRepositoryImpl.printDuplicate();
//
//    }

}
