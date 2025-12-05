package main.java.inputs;

import main.java.items.Item;
import main.java.states.Player;

import java.util.Scanner;

public class SellInput {
    public void execute(Player player, Scanner input) {
        System.out.println();
        if (!player.listItems()) {
            return;
        }
        System.out.println();
        System.out.print("Item: ");
        String itemName = input.next();
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        sellItem(player, itemName, quantity);
    }

    public static void sellItem(Player player, String itemName, int quantity) {
        Item item = findItem(player, itemName);

        if (item == null) {
            System.out.println("You don't have that item!");
            return;
        }

        if (item.getQuantity() < quantity) {
            System.out.println("Not enough " + itemName + " to sell!");
            return;
        }

        int totalValue = item.getValue() * quantity;
        player.addMoney(totalValue);
        player.removeItem(item, quantity);

        System.out.println("Sold " + quantity + " " + itemName + " for " + totalValue + " coins!");
    }

    public static Item findItem(Player player, String itemName) {
        for (Item item : player.getInventory()) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
