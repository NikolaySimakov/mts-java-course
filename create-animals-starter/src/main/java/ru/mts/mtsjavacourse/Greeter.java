package ru.mts.mtsjavacourse;

import java.util.HashMap;
import java.util.List;

public class Greeter {

    private final GreetingConfig config;

    public Greeter(GreetingConfig config) {
        this.config = config;
    }

    public GreetingConfig getConfig() {
        return this.config;
    }
}
