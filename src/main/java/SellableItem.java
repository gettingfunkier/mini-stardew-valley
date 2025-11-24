package main.java;

public class SellableItem extends Item {
    private String name;
    private String type;
    private int price;

    public SellableItem(String name, String type, int price) {
        this.name = name;
        this.price = price;
        this.type = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
