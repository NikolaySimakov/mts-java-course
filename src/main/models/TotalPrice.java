package main.models;

public class TotalPrice {

    private final double withDiscount;
    private final double withoutDiscount;

    public TotalPrice(double withDiscount, double withoutDiscount) {
        this.withDiscount = withDiscount;
        this.withoutDiscount = withoutDiscount;
    }

    public double getWithDiscount() {
        return this.withDiscount;
    }

    public double getWithoutDiscount() {
        return this.withoutDiscount;
    }

}
