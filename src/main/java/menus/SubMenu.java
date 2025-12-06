package main.java.menus;

public abstract class SubMenu {
    public static void farmingMenu() {
        System.out.println("Farming:");
        System.out.println("  ├── 1. Inspect");
        System.out.println("  ├── 2. Water");
        System.out.println("  ├── 3. Plant");
        System.out.println("  └── 4. Harvest");
        System.out.println();
        System.out.print("0. Return");
        System.out.print("> ");
    }

    public static void tradingMenu() {
        System.out.println("Trading:");
        System.out.println("  ├── 1. Sell");
        System.out.println("  └── 2. Shop");
        System.out.println();
        System.out.println("0. Return");
        System.out.print("> ");
    }
}
