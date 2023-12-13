package main.models;

/**
 * Класс main.models.Purchase
 * содержит переменные
 * int quantity
 * double price
 * double discount
 * метод calculateTotal для подсчета общей суммы
 * без скидки и со скидкой
 */
public class Purchase {
    private int quantity; // Количество товаров
    private double price; // сумма товара
    private double discount; // скидка на товар

    public Purchase(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

}
