package ru.mts.mtsjavacourse.app;

import ru.mts.mtsjavacourse.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppService {

    @Autowired
    private Greeter greeter;


    @PostConstruct
    public void init() {
        System.out.println(greeter.getConfig());
    }

}
