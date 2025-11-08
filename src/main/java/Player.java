package main.java;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    protected ArrayList<Item> inventory;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item newItem) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(newItem.getName())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                return;
            }
        }

        inventory.add(newItem);
    }

    public void removeItem(Item item, int quantity) {
        for (int i = 0; i <= quantity; i++) {
            this.inventory.remove(item);
        }
    }

    public void clearInventory() {
        this.inventory.clear();
    }

    public void listItems() {
        System.out.println("Inventory:");
        for (Item item : this.inventory) {
            System.out.println(item.getQuantity() + "x " + item.getName());
        }
    }

    public void sellItem(Item item) {
        this.inventory.remove(item);
        addMoney(item.getValue());
    }
}
