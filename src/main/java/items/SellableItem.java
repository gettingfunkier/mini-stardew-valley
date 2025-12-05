package main.java.items;

import main.java.enums.ItemType;

public class SellableItem extends Item {
    private String name;
    private int price;

    public SellableItem(String name, ItemType type, int price) {
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
