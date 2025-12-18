package main.java.writers;

import main.java.items.Item;
import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Shop;

import java.io.FileWriter;
import java.io.IOException;

public class Save {
    public static void playerToFile(int SAVE_FILE, Player player) {
        try (FileWriter fw = new FileWriter("saves/SAVE_FILE_" + SAVE_FILE + "/player.sdv")) {

            fw.write("name: " + player.getName() + "\n");
            fw.write("money: " + player.getMoney() + "\n");
            fw.write("xp: " + player.getXp() + "\n");
            fw.write("level: " + player.getLevel() + "\n");
            fw.write("LEVEL_HEAD: " + player.getLEVEL_HEAD() + "\n");

            fw.write("inventory_size: " + player.getInventorySize() + "\n");

            for (int i = 0; i < player.getInventory().size(); i++) {
                Item item = player.getInventory().get(i);
                fw.write("inventory_item_" + i + ": " + item.getId() + ", " + item.getQuantity() + "\n");
            }

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void calendarToFile(int SAVE_FILE, Calendar calendar) {
        try (FileWriter fw = new FileWriter("saves/SAVE_FILE_" + SAVE_FILE + "/calendar.sdv")) {

            fw.write("day: " + calendar.getDay() + "\n");
            fw.write("season: " + calendar.getSeason() + "\n");
            fw.write("seasonIndex: " + calendar.getSeasonIndex() + "\n");

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void farmToFile(int SAVE_FILE, Farm farm) {
        try (FileWriter fw = new FileWriter("saves/SAVE_FILE_" + SAVE_FILE + "/farm.sdv")) {

            fw.write("name: " + farm.getName() + "\n");
            fw.write("capacity: " + farm.getCapacity() + "\n");

            // MUST SAVE PLOT STATES TOO!!

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    // MUST SAVE SHOP TOO!!
}
