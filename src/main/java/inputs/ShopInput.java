package main.java.inputs;

import main.java.Player;
import main.java.Shop;

import java.util.Scanner;

public class ShopInput {
    public void execute(Player player, Scanner input) {
        Shop shop = new Shop(player);
        shop.printShopCatalogue();
        System.out.println();
        System.out.print("> ");
        String itemName = input.next();
        shop.buyItem(player, itemName);

    }
}
