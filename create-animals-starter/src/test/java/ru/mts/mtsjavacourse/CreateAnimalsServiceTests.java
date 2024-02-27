package ru.mts.mtsjavacourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mts.mtsjavacourse.models.AbstractAnimal;
import ru.mts.mtsjavacourse.models.animals.Wolf;
import ru.mts.mtsjavacourse.services.AnimalFactory;
import ru.mts.mtsjavacourse.services.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateAnimalsServiceTests {

    @InjectMocks
    private CreateAnimalServiceImpl createAnimalServiceMock;
    @Mock
    private AnimalFactory factory;

    @Test
    @DisplayName("Animal creation test")
    public void animalCreationTest() {
        AbstractAnimal wolfMock = new Wolf("Wolf", "breed", "name", new BigDecimal("123.123"), "character", LocalDate.now());
        when(factory.createAnimal(anyInt(), anyString(), any(BigDecimal.class), anyString(), any(LocalDate.class))).thenReturn(wolfMock);
        AbstractAnimal createdWolf = createAnimalServiceMock.createAnimal(0);

        assertSame(createdWolf.getClass(), wolfMock.getClass());
        assertSame(createdWolf, wolfMock);
    }

}
