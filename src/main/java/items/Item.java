package main.java.items;

import main.java.Type;

public class Item extends ItemCore {
    protected int quantity;
    protected int value;

    public Item(String name, int quantity, Type type, int value) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.value = value;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
