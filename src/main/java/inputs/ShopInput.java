package main.java.inputs;

import main.java.states.Player;
import main.java.Shop;
import main.java.catalogues.ShopCatalogue;

import java.util.Scanner;

public class ShopInput {
    public void execute(Player player, Scanner input) {
        Shop shop = new Shop();
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
