package main.java.menus;

import main.java.states.Calendar;
import main.java.states.Player;

public abstract class MainMenu {
    public static void oldMenu() {
        System.out.println("1. Check plots");
        System.out.println("2. Advance day");
        System.out.println("3. Water");
        System.out.println("4. Plant");
        System.out.println("5. Harvest");
        System.out.println("6. Sell");
        System.out.println("7. Shop");
        System.out.println("8. List inventory");
        System.out.println("9. Crop catalogue");
        System.out.println("0. Quit game");
        System.out.println();
        System.out.print("> ");
    }

    public static void defaultMenu(Player player, Calendar calendar) {
        System.out.println();
        System.out.println("--- [ Day " + calendar.getDay() + " of " + calendar.getSeason() + " ] ---------");
        System.out.println(player.getName() + ": " + player.getMoney() + " coins / Level " + player.getLevel() + " (" + player.getXp() + "/" + player.getLEVEL_HEAD() +")");
        System.out.println();
        System.out.println("1. Farming");
        System.out.println("2. Trading");
        System.out.println(" | ");
        System.out.println("3. List Inventory");
        System.out.println("4. Crop Catalogue");
        System.out.println(" | ");
        System.out.println("5. Advance Day");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("> ");
    }
}
