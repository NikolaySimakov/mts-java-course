
public class Main {
    public static void calculateTotal(Purchase purchase) {
        double totalWithoutDiscount = purchase.quantity * purchase.price;
        double totalWithDiscount = totalWithoutDiscount * (1 - purchase.discount);
        System.out.println("Общая сумма покупки без скидки: " + String.format("%.2f", totalWithoutDiscount));
        System.out.println("Сумма со скидкой: " + String.format("%.2f", totalWithDiscount));
        System.out.println();
    }

    public static void main(String[] args) {

        // 1)
        Purchase purchase1 = new Purchase(10, 25.50, 0.75);
        calculateTotal(purchase1);

        // 2)
        Purchase purchase2 = new Purchase(6, 100.25, 42.575);
        calculateTotal(purchase2);

        // 3)
        Purchase purchase3 = new Purchase(19, 15.75, 59.1);
        calculateTotal(purchase3);

    }
}