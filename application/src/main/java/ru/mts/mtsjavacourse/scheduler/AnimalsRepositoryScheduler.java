package ru.mts.mtsjavacourse.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AnimalsRepositoryScheduler {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Scheduled(fixedRate = 60_000L)
    public void executeAllAnimalsRepositoryMethods() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = localDateTime.format(timeFormatter);
        System.out.println("Time: " + timeString);
        System.out.printf("All animals: \n%s", animalsRepository.getAnimals().toString());
        System.out.println();
        System.out.printf("findLeapYearNames: \n%s", animalsRepository.findLeapYearNames().toString());
        System.out.println();
        System.out.printf("findOlderAnimal: \n%s", animalsRepository.findOlderAnimal(5).toString());
        System.out.println();
        System.out.printf("findDuplicate: \n%s", animalsRepository.findDuplicate().toString());
        System.out.println();
        System.out.println("printDuplicate: ");
        animalsRepository.printDuplicate();
    }

}
