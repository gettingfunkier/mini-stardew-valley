package main.java.items;

import main.java.Type;

public class SellableItem extends Item {
    private String name;
    private int price;

    public SellableItem(String name, Type type, int price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
