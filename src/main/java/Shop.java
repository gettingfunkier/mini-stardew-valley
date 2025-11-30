package main.java;

import main.java.items.Item;
import main.java.items.SellableItem;

import java.util.ArrayList;

public class Shop {
    private final ArrayList<SellableItem> shopCatalogue;
    SellableItem fish = new SellableItem("Rug", Type.DECOR, 40);
    SellableItem latte = new SellableItem("Latte", Type.COFFEE, 255);

    public Shop(Player player) {
        shopCatalogue = new ArrayList<>();
        shopCatalogue.add(fish);
        shopCatalogue.add(latte);
    }

    public void printShopCatalogue() {
        for (SellableItem item : shopCatalogue) {
            System.out.println("⤷ " + item.getName() + " for " + item.getPrice() + " coins");
        }
    }

    public void buyItem(Player player, String itemName) {
        if (itemName.equals("r")) {
            return;
        }

        int money = player.getMoney();
        SellableItem item = getItemFromCatalogue(itemName);
        if (item != null) {
            if (item.getPrice() <= money) {
                shopCatalogue.remove(item);
                player.setMoney(player.getMoney() - item.getPrice());
                Item newItem = new Item(itemName, 1, item.getType(), item.getPrice() / 3);
                player.addItem(newItem);
                System.out.println(item.getName() + " bought for " + item.getPrice() + " coins");
                return;
            }
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("We don't sell that here!");
        return;
    }

    public SellableItem getItemFromCatalogue(String itemName) {
        for (SellableItem item : shopCatalogue) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
