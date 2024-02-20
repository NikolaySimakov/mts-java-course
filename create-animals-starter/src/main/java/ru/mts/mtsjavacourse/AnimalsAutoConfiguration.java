package ru.mts.mtsjavacourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@ConditionalOnClass(AnimalsData.class)
@EnableConfigurationProperties(AnimalsProperties.class)
public class AnimalsAutoConfiguration {

    @Autowired
    private AnimalsProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public AnimalsConfig greeterConfig() {

        // TODO: remove later because system can't define properties
        System.setProperty("cat.names", "Barsik,Persik,Barsik1,Persik1");
        System.setProperty("dog.names", "Bella,Max,Luna,Rex,Daisy");
        System.setProperty("shark.names", "Orca,Hammerhead,Tiger,Great White,Silvertip");
        System.setProperty("wolf.names", "Fenrir,Blaze,Hati,Balto,Dakota");


        List<String> catNames = greeterProperties.getCatNames() == null
                ? Collections.singletonList(System.getProperty("cat.names"))
                : greeterProperties.getCatNames();

        List<String> dogNames = greeterProperties.getDogNames() == null
                ? Collections.singletonList(System.getProperty("dog.names"))
                : greeterProperties.getDogNames();

        List<String> sharkNames = greeterProperties.getSharkNames() == null
                ? Collections.singletonList(System.getProperty("shark.names"))
                : greeterProperties.getSharkNames();

        List<String> wolfNames = greeterProperties.getWolfNames() == null
                ? Collections.singletonList(System.getProperty("wolf.names"))
                : greeterProperties.getWolfNames();

        AnimalsConfig greetingConfig = new AnimalsConfig();
        greetingConfig.put("catNames", catNames);
        greetingConfig.put("dogNames", dogNames);
        greetingConfig.put("sharkNames", sharkNames);
        greetingConfig.put("wolfNames", wolfNames);
        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public AnimalsData greeter(AnimalsConfig greetingConfig) {
        return new AnimalsData(greetingConfig);
    }
}
