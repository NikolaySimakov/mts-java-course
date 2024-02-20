package ru.mts.mtsjavacourse.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
        System.out.printf("findLeapYearNames: \n%s", Arrays.toString(new List[]{animalsRepository.findLeapYearNames()}));
        System.out.println();
        System.out.printf("findOlderAnimal: \n%s", Arrays.toString(new List[]{animalsRepository.findOlderAnimal(5)}));
        System.out.println();
        System.out.printf("findDuplicate: \n%s", animalsRepository.findDuplicate());
        System.out.println();
        System.out.println("printDuplicate: ");
        animalsRepository.printDuplicate();
    }

}
