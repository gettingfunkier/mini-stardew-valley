package main.java.writers;

import main.java.items.Crop;
import main.java.items.Item;
import main.java.items.Sellable;
import main.java.states.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

            for (int i = 1; i <= farm.getCapacity(); i++) {

                Plot plot = farm.getPlot(i);

                if (!plot.isEmpty()) {
                    Crop crop = plot.getCrop();
                    fw.write("plot_" + i + ": " + plot.getState() + ","
                                + crop.getId() + ", " + crop.getCurrentDay() + "\n");
                }

                else {
                    fw.write("plot_" + i + ": empty\n");
                }

            }

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void shopToFile(int SAVE_FILE, Shop shop) {
        try (FileWriter fw = new FileWriter("saves/SAVE_FILE_" + SAVE_FILE + "/shop.sdv")) {

            ArrayList<Sellable> shopCatalogue = shop.getShopCatalogue();

            for (Sellable sellableItem : shopCatalogue) {
                fw.write(sellableItem.getId() + "," + sellableItem.getPrice() + "," + sellableItem.getQuantity() + "\n");
            }

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void execute(int SAVE_FILE, Player player, Calendar calendar, Farm farm, Shop shop) {
        playerToFile(SAVE_FILE, player);
        calendarToFile(SAVE_FILE, calendar);
        farmToFile(SAVE_FILE, farm);
        shopToFile(SAVE_FILE, shop);
    }
}

