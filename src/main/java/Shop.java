package main.java;

import main.java.catalogues.ShopCatalogue;
import main.java.items.Item;
import main.java.items.SellableItem;
import main.java.states.Player;

import java.util.ArrayList;

public class Shop {
    private ArrayList<SellableItem> shopCatalogue;

    public Shop() {
        this.shopCatalogue = ShopCatalogue.getShopCatalogue();
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
    }

    public void addItemToShop(SellableItem item) {
        shopCatalogue.add(item);
    }

    public void printShopCatalogue() {
        for (SellableItem item : shopCatalogue) {
            System.out.println("⤷ " + item.getName() + " for " + item.getPrice() + " coins");
        }
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
