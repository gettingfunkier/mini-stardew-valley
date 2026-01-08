package main.java.writers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Load {

    public static void loadSave(int slot) {
        loadPlayer(slot);
    }

    public static void loadPlayer(int slot) {

        String line;
        String playerName = "";
        int money = 0;
        int xp = 0;
        int level = 0;
        int LEVEL_HEAD = 0;
        int inventory_size = 0;
        ArrayList<String[]> inventory = new ArrayList<>();

        try (BufferedReader playerF = Files.newBufferedReader(Path.of("saves/SAVE_FILE_" + slot + "/player.sdv"))) {

            while ((line = playerF.readLine()) != null) {

                if (line.startsWith("name:")) {
                    playerName = line.split(": ")[1];
                }

                if (line.startsWith("money:")) {
                    money = Integer.parseInt(line.split(": ")[1]);
                }

                if (line.startsWith("xp:")) {
                    xp = Integer.parseInt(line.split(": ")[1]);
                }

                if (line.startsWith("level:")) {
                    level = Integer.parseInt(line.split(": ")[1]);
                }

                if (line.startsWith("LEVEL_HEAD:")) {
                    LEVEL_HEAD = Integer.parseInt(line.split(": ")[1]);
                }

                if (line.startsWith("inventory_size:")) {
                    inventory_size = Integer.parseInt(line.split(": ")[1]);
                }

                if (line.startsWith("inventory_item")) {
                    inventory.add(line.split(": ")[1].split(", "));
                }
            }

            System.out.print(playerName + ", " + money + " coins, " + xp + " xp, level "
                    + level + ", head " + LEVEL_HEAD + ", size " + inventory_size);

            for (String[] item : inventory) {
                System.out.print(", " + item[0]);
            }

            System.out.println();


        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
