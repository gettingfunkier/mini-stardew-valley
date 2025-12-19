package main.java.menus;

import main.java.previews.SavePreview;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static main.java.previews.SavePreview.readSavePreview;

public abstract class SubMenu {
    public static void farmingMenu() {
        System.out.println("Farming:");
        System.out.println("  ├── 1. Inspect");
        System.out.println("  ├── 2. Water");
        System.out.println("  ├── 3. Plant");
        System.out.println("  └── 4. Harvest");
        System.out.println();
        System.out.println("0. Return");
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

    public static void savesMenu() {

        System.out.println("Choose a slot:");

        for (int i = 1; i <= 4; i++) {
            Path slotPath = Paths.get("saves/SAVE_FILE_" + i + "/player.sdv");
            if (i != 4) {

                if (Files.exists(slotPath)) {
                    SavePreview preview = readSavePreview(slotPath);
                    System.out.println("  ├── Save " + i + ": " + preview.playerName);

                } else {
                    System.out.println("  ├── Save " + i);
                }
            }

            else {

                if (Files.exists(slotPath)) {
                    SavePreview preview = readSavePreview(slotPath);
                    System.out.println("  └── Save " + i + ": " + preview.playerName);

                } else {
                    System.out.println("  └── Save " + i);
                }
            }

        }

        System.out.println();
        System.out.print("> ");
    }
}
