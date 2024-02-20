package ru.mts.mtsjavacourse;

import java.util.List;

public class AnimalsData {

    private final AnimalsConfig config;

    public AnimalsData(AnimalsConfig config) {
        this.config = config;
    }

    public AnimalsConfig getConfig() {
        return this.config;
    }

    public List<String> getWolfNames() {
        return config.get("wolfNames");
    }

    public List<String> getSharkNames() {
        return config.get("sharkNames");
    }

    public List<String> getDogNames() {
        return config.get("dogNames");
    }

    public List<String> getCatNames() {
        return config.get("catNames");
    }
}
