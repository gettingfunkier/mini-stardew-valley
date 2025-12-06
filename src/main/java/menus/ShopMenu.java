package main.java.menus;

import main.java.states.Player;
import main.java.states.Shop;

import java.util.Scanner;

public abstract class ShopMenu {
    public static void defaultMenu(Player player, Shop shop, Scanner input) {
        System.out.println();
        System.out.println("Shop Catalogue:");
        shop.printShopCatalogue();
        System.out.println();
        System.out.println("('r' to return to menu)");
        System.out.print("> ");
        String itemName = input.next();
        shop.buyItem(player, itemName);
    }
}
