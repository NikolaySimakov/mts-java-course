//package app;
//
//import app.models.AbstractAnimal;
//import app.models.Animal;
//import app.repositories.AnimalsRepository;
//import app.services.CreateAnimalService;
//import app.services.CreateAnimalServiceImpl;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//import java.util.List;
//
//@ComponentScan
//public class Main {
//
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//
//        CreateAnimalService animalServiceImpl = context.getBean(CreateAnimalService.class);
//        AnimalsRepository animalsRepository = context.getBean(AnimalsRepository.class);
//
////        int n = 4;
////        animalServiceImpl.createAnimalsN(n);
//
//        System.out.println();
//        System.out.println("--------findLeapYearNames--------");
//        System.out.println();
//        System.out.println(animalsRepository.findLeapYearNames());
//        System.out.println();
//        System.out.println("--------findOlderAnimal--------");
//        System.out.println();
//        for (AbstractAnimal animal : animalsRepository.findOlderAnimal(5)) {
//            System.out.println(animal.shortInfo());
//        }
//        System.out.println();
//        System.out.println("--------printDuplicate-------");
//        System.out.println();
//        animalsRepository.printDuplicate();
//
//    }
//}
