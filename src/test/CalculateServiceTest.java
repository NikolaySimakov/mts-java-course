package test;

import org.junit.jupiter.api.Test;

import main.models.Purchase;
import main.models.TotalPrice;
import main.service.CalculateService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    @Test
    public void calculateServiceCheck() {
        TotalPrice totalSum;

        totalSum = CalculateService.calculateTotal(new Purchase(10, 25.50, 0.75));
        assertEquals(totalSum.getWithoutDiscount(), 255.0);
        assertEquals(totalSum.getWithDiscount(), 253.09);

        totalSum = CalculateService.calculateTotal(new Purchase(6, 100.25, 42.575));
        assertEquals(totalSum.getWithoutDiscount(), 601.5);
        assertEquals(totalSum.getWithDiscount(), 345.41);

        totalSum = CalculateService.calculateTotal(new Purchase(19, 15.75, 59.1));
        assertEquals(totalSum.getWithoutDiscount(), 299.25);
        assertEquals(totalSum.getWithDiscount(), 122.39);
    }
}