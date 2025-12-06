package main.java.inputs;

import main.java.menus.ShopMenu;
import main.java.states.Player;
import main.java.states.Shop;

import java.util.Scanner;

public class ShopInput {
    public void execute(Player player, Shop shop, Scanner input) {
        ShopMenu.defaultMenu(player, shop, input);
    }
}
