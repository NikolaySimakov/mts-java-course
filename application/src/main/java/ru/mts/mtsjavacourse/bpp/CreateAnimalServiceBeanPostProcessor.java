package ru.mts.mtsjavacourse.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CreateAnimalServiceBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("createAnimalService")) {
            System.out.println("Before init createAnimalService");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
