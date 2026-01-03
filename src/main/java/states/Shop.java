package main.java.states;

import main.java.catalogues.ShopCatalogue;
import main.java.items.Item;
import main.java.items.Sellable;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Sellable> shopCatalogue;

    public Shop() {
        this.shopCatalogue = ShopCatalogue.getShopCatalogue();
    }

    public void buyItem(Player player, String itemName) {
        if (itemName.equals("r")) {
            return;
        }

        int money = player.getMoney();
        Sellable item = getItemFromShopCatalogue(itemName);

        if (item != null) {
            if (item.getPrice() <= money) {
                shopCatalogue.remove(item);
                Item newItem = new Item(item.getId(), itemName, 1, item.getType(), item.getPrice() / 3);

                player.setMoney(player.getMoney() - item.getPrice());
                player.addItem(newItem);

                System.out.println(item.getName() + " bought for " + item.getPrice() + " coins");
                player.addXp(item.getPrice() / 5);

                return;
            }
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("We don't sell that here!");
    }

    public void addItemToShopCatalogue(Sellable item) {
        shopCatalogue.add(item);
    }

    public void printShopCatalogue() {
        for (Sellable item : shopCatalogue) {
            System.out.println("⤷ " + item.getName() + " for " + item.getPrice() + " coins");
        }
    }

    public Sellable getItemFromShopCatalogue(String itemName) {
        for (Sellable item : shopCatalogue) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Sellable> getShopCatalogue() {
        return shopCatalogue;
    }
}
