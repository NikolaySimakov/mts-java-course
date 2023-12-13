package main.service;

import main.Purchase;
import main.models.TotalPrice;

public class CalculateService {

    private static double round(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public static TotalPrice calculateTotal(Purchase purchase) {
        double totalWithoutDiscount = purchase.getQuantity() * purchase.getPrice();
        double totalWithDiscount = totalWithoutDiscount * (1 - purchase.getDiscount() / 100);
        return new TotalPrice(round(totalWithDiscount), round(totalWithoutDiscount));
    }
}
