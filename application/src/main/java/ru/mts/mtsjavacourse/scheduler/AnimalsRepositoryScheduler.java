package ru.mts.mtsjavacourse.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.mtsjavacourse.exceptions.AnimalsListException;
import ru.mts.mtsjavacourse.repositories.AnimalsRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class AnimalsRepositoryScheduler {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    @Autowired
    private AnimalsRepository animalsRepository;

    @PostConstruct
    public void scheduledTasks() {
        scheduler.scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("PrintDuplicate");

            System.out.println("Current Thread name: " + Thread.currentThread().getName());

            animalsRepository.printDuplicate();

        }, 0, 10, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("FindAverageAge");

            System.out.println("Current Thread name: " + Thread.currentThread().getName());

            animalsRepository.getAnimals().forEach((key, value) ->
                    System.out.println(key + ": " + animalsRepository.findAverageAge(animalsRepository.getAnimals().get(key))));

        }, 0, 20, TimeUnit.SECONDS);
    }

    @Scheduled(fixedRate = 60_000L)
    public void executeAllAnimalsRepositoryMethods() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = localDateTime.format(timeFormatter);
        System.out.println("Time: " + timeString);

        try {

            System.out.printf("All animals: \n%s\n", animalsRepository.getAnimals().toString());
            System.out.printf("findLeapYearNames: \n%s\n", animalsRepository.findLeapYearNames().toString());
            System.out.printf("findOlderAnimal: \n%s\n", animalsRepository.findOlderAnimal(5).toString());
            System.out.printf("findDuplicate: \n%s\n", animalsRepository.findDuplicate().toString());

            System.out.println("Old and expensive:");
            animalsRepository.getAnimals().forEach((key, value) ->
                    System.out.println(key + ": " + animalsRepository.findOldAndExpensive(animalsRepository.getAnimals().get(key))));

            System.out.println("Min cost animals:");
            animalsRepository.getAnimals().forEach((key, value) ->
            {
                try {
                    System.out.println(key + ": " + animalsRepository.findMinConstAnimals(animalsRepository.getAnimals().get(key)));
                } catch (AnimalsListException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}
