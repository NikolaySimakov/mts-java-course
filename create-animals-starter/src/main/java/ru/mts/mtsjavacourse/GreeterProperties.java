package ru.mts.mtsjavacourse;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "application.animal")
public class GreeterProperties {
    private List<String> catNames;
    private List<String> dogNames;
    private List<String> sharkNames;
    private List<String> wolfNames;

    public List<String> getCatNames() {
        return this.catNames;
    }

    public List<String> getDogNames() {
        return this.dogNames;
    }

    public List<String> getSharkNames() {
        return this.sharkNames;
    }

    public List<String> getWolfNames() {
        return this.wolfNames;
    }
}
