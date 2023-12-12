/**
 * Класс Purchase
 * содержит переменные
 * int quantity
 * double price
 * double discount
 * метод calculateTotal для подсчета общей суммы
 * без скидки и со скидкой
 */
public class Purchase {
    public int quantity; // Количество товаров
    public double price; // сумма товара
    public double discount; // скидка на товар

    public Purchase(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount / 100; // сразу переводим проценты в долю
    }
}
