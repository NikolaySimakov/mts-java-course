package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Wolf;
import ru.mts.mtsjavacourse.services.CreateAnimalService;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CreateAnimalsServiceTests {

    @MockBean
    private CreateAnimalServiceImpl createAnimalServiceMock;
    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("Animal creation test")
    public void animalCreationTest() {
        AbstractAnimal wolfMock = new Wolf("breed", "name", new BigDecimal("123.123"), "character", LocalDate.now());
        when(createAnimalServiceMock.createAnimal(0)).thenReturn(wolfMock);

        CreateAnimalService createAnimalServiceContext = context.getBean(CreateAnimalServiceImpl.class);
        AbstractAnimal wolf = createAnimalServiceContext.createAnimal(0);

        assertSame(createAnimalServiceMock.createAnimal(0).getClass(), wolf.getClass());
        assertSame(createAnimalServiceMock.createAnimal(0), wolf);
        System.out.println(wolf.shortInfo());
    }

}
