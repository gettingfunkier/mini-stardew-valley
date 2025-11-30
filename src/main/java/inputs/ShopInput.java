package main.java.inputs;

import main.java.Player;
import main.java.Shop;

import java.util.Scanner;

public class ShopInput {
    public void execute(Player player, Scanner input) {
        Shop shop = new Shop(player);
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
