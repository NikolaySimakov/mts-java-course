package create.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {

    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greeterConfig() {

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

        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put("catNames", catNames);
        greetingConfig.put("dogNames", dogNames);
        greetingConfig.put("sharkNames", sharkNames);
        greetingConfig.put("wolfNames", wolfNames);

        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }
}
