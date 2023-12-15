package main.service;

import main.models.Purchase;
import main.models.TotalPrice;

public class CalculateService {

    private static double round(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public static TotalPrice calculateTotal(Purchase purchase) {
        if (!(purchase.getQuantity() >= 0 && purchase.getPrice() >= 0 && purchase.getDiscount() >= 0)) {
            throw new RuntimeException();
        }

        double totalWithoutDiscount = purchase.getQuantity() * purchase.getPrice();
        double totalWithDiscount = totalWithoutDiscount * (1 - purchase.getDiscount() / 100);
        return new TotalPrice(round(totalWithDiscount), round(totalWithoutDiscount));
    }
}
