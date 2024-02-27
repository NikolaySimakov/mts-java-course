package ru.mts.mtsjavacourse.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "animal")
@Validated
public class AnimalsProperties {
//    @NotEmpty
    private List<String> catNames;
//    @NotEmpty
    private List<String> dogNames;
//    @NotEmpty
    private List<String> sharkNames;
//    @NotEmpty
    private List<String> wolfNames;

    public List<String> getCatNames() {
        return catNames;
    }

    public void setCatNames(List<String> catNames) {
        this.catNames = catNames;
    }

    public List<String> getDogNames() {
        return dogNames;
    }

    public void setDogNames(List<String> dogNames) {
        this.dogNames = dogNames;
    }

    public List<String> getSharkNames() {
        return sharkNames;
    }

    public void setSharkNames(List<String> sharkNames) {
        this.sharkNames = sharkNames;
    }

    public List<String> getWolfNames() {
        return wolfNames;
    }

    public void setWolfNames(List<String> wolfNames) {
        this.wolfNames = wolfNames;
    }

    public List<String> getNamesByIndex(int i) {
        return switch (i) {
            case 0 -> getWolfNames();
            case 1 -> getSharkNames();
            case 2 -> getCatNames();
            case 3 -> getDogNames();
            default -> throw new IllegalArgumentException("Error animal names");
        };
    }
}
