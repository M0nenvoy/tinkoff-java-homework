package edu.hw3.Task6;

public class Stock {
    private final float price;
    private final int id;

    Stock(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public float getId() {
        return id;
    }
}
