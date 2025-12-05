package main.java.states;

import main.java.items.Item;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int xp;
    private int level;
    private int LEVEL_HEAD = 200;
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

    public boolean listItems() {
        if (inventory.isEmpty()) {
            System.out.println("You have no items in your inventory");
            return false;
        }
        System.out.println("Inventory:");
        for (Item item : this.inventory) {
            System.out.println(item.getQuantity() + "x " + item.getName() + " (" + item.getType() + ")");
        }
        return true;
    }

    public void sellItem(Item item) {
        this.inventory.remove(item);
        addMoney(item.getValue());
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int amount) {
        this.xp += amount;
        updateLevel();
    }

    public int getLevel() {
        return level;
    }

    private void updateLevel() {
        if (xp >= LEVEL_HEAD) {
            System.out.println();
            System.out.println("LEVEL UP!!");
        }

        while (xp >= LEVEL_HEAD) {
            level++; // level + 1
            xp -= LEVEL_HEAD; // reset xp (keeps overflow)
            LEVEL_HEAD += (int)(LEVEL_HEAD / 10); // increases level head
        }
    }

    public int getLEVEL_HEAD() {
        return LEVEL_HEAD;
    }
}
