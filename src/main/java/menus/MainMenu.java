package main.java.menus;

public abstract class MainMenu {
    public static void backupMenu() {
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

    public static void defaultMenu() {
        System.out.println("1. Farming");
        System.out.println("2. Trading");
        System.out.println(" | ");
        System.out.println("3. List Inventory");
        System.out.println("4. Crop catalogue");
        System.out.println(" | ");
        System.out.println("5. Advance Day");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("> ");
    }
}
