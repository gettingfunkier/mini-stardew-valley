package main.java.items;

import main.java.enums.ItemType;

public class Item extends ItemCore {
    protected int quantity;
    protected int value;

    public Item(String id, String name, int quantity, ItemType type, int value) {
        super(id, name, type);
        this.quantity = quantity;
        this.value = value;
    }

    public Item(Item other) {
        super(other.id, other.name, other.type);
        this.quantity = other.quantity;
        this.value = other.value;
    }

    public Item() {
        super(null, null, null);
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

    public ItemType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
