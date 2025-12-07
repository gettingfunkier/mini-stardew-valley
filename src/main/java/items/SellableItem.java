package main.java.items;

import main.java.enums.ItemType;

public class SellableItem extends Item {
    private int price;

    public SellableItem(String id, String name, ItemType type, int price) {
        super(id, name, 0, type, price);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
