package main.java.writers;

import main.java.items.Item;
import main.java.runtime.Content;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Plot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static main.java.utilities.Parser.*;

public class Load {

    public static void loadSave(int slot) {
        Player player = loadPlayer(slot);
        loadFarm(slot);
    }

    public static Player loadPlayer(int slot) {

        String line;
        String playerName = "";
        int money = 0;
        int xp = 0;
        int level = 0;
        int LEVEL_HEAD = 0;
        int inventory_size = 0;
        ArrayList<Item> inventory = new ArrayList<>();

        try (BufferedReader playerF = Files.newBufferedReader(Path.of("saves/SAVE_FILE_" + slot + "/player.sdv"))) {

            while ((line = playerF.readLine()) != null) {

                if (line.startsWith("name:")) {
                    playerName = parseString(line);
                }

                if (line.startsWith("money:")) {
                    money = parseInt(line);
                }

                if (line.startsWith("xp:")) {
                    xp = parseInt(line);
                }

                if (line.startsWith("level:")) {
                    level = parseInt(line);
                }

                if (line.startsWith("LEVEL_HEAD:")) {
                    LEVEL_HEAD = parseInt(line);
                }

                if (line.startsWith("inventory_size:")) {
                    inventory_size = parseInt(line);
                }

                if (line.startsWith("inventory_item")) {
                    String[] parse = parseItem(line);
                    // parse[0] = "CROP_parsnip"    (id)
                    // parse[1] = "3"               (quantity)

                    Item vessel = Content.getItem(parse[0]);

                    if (vessel != null) {
                        Item item = new Item(vessel);
                        item.setQuantity(Integer.parseInt(parse[1]));

                        inventory.add(item);
                    }
                }
            }

            return new Player(playerName, money, xp, level, LEVEL_HEAD, inventory);

        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    public static void loadFarm(int slot) {

        String line;
        String farmName = "";
        int capacity = 0;


        try (BufferedReader farmF = Files.newBufferedReader(Path.of("saves/SAVE_FILE_" + slot + "/farm.sdv"))) {

            while ((line = farmF.readLine()) != null) {

                if (line.startsWith("name:")) {
                    farmName = line.split(": ")[1];
                }

                if (line.startsWith("capacity:")) {
                    capacity = Integer.parseInt(line.split(": ")[1]);
                }

                Farm farm = new Farm(farmName, capacity);

                if (line.startsWith("plot_")) {

                    Plot plot = new Plot(
                            parsePlotID(),
                            parsePlotCrop()
                    );

                }
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }

    }

    public static void loadCalendar(int slot) {

        String line;
        int day;
        String season;

    }
}
