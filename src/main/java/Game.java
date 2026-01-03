package main.java;

import main.java.catalogues.CropCatalogue;
import main.java.inputs.*;
import main.java.items.Crop;
import main.java.menus.StartMenu;
import main.java.menus.SubMenu;
import main.java.states.*;
import main.java.menus.MainMenu;
import main.java.writers.Save;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.Start.startGame;
import static main.java.catalogues.CropCatalogue.getCrops;

public class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StartMenu.startMenu();
        final int start = input.nextInt();

        int saveFile;

        while (true) {
            SubMenu.savesMenu();

            if (!input.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input!" + "\n");
                input.next();
                continue;
            }

            saveFile = input.nextInt();

            if (saveFile < 1 || saveFile > 4) {
                System.out.println();
                System.out.println("Invalid slot! (1 to 4)" + "\n");
                continue;
            }

            break;
        }

        GameState game = startGame();
        mainMenu(saveFile, game.player, game.farm, game.shop, game.calendar, game.available);

    }



    public static void mainMenu(int saveFile, Player player, Farm farm, Shop shop, Calendar calendar, ArrayList<Crop> available) {
        String season = calendar.getSeason();

        while (true) {
            Scanner input = new Scanner(System.in);
            printMenu(player, calendar);

            ArrayList<Plot> allPlots = farm.getAllPlots();
            ArrayList<Plot> emptyPlots = getEmptyPlots(farm);

            if (!calendar.getSeason().equals(season)) {
                changeSeason(farm);
                season = calendar.getSeason();
            }

            try {
                int action = input.nextInt();
                switch (action) {
                    case 0:
                        return;
                    case 1:
                        SubMenu.farmingMenu();
                        int farmingAction = input.nextInt();
                        switch (farmingAction) {
                            case 0:
                                break;
                            case 1:
                                CheckPlotsInput checking = new CheckPlotsInput();
                                checking.execute(farm);
                                break;
                            case 2:
                                WaterInput watering = new WaterInput();
                                watering.execute(player, farm, allPlots, input);
                                break;
                            case 3:
                                PlantInput planting = new PlantInput();
                                planting.execute(farm, calendar, emptyPlots, available, input);
                                break;
                            case 4:
                                HarvestInput harvesting = new HarvestInput();
                                harvesting.execute(allPlots, farm, player, input);
                                break;
                        }
                        break;
                    case 2:
                        SubMenu.tradingMenu();
                        int tradingAction = input.nextInt();
                        switch (tradingAction) {
                            case 0:
                                break;
                            case 1:
                                SellInput selling = new SellInput();
                                selling.execute(player, input);
                                break;
                            case 2:
                                ShopInput shopping = new ShopInput();
                                shopping.execute(player, shop, input);
                                break;
                        }
                        break;
                    case 3:
                        ListInventoryInput listingInventory = new ListInventoryInput();
                        listingInventory.execute(player);
                        break;
                    case 4:
                        CropCatalogueInput cropCatalogue = new CropCatalogueInput();
                        cropCatalogue.execute();
                        break;
                    case 5:
                        AdvanceDayInput advancingDay = new AdvanceDayInput();
                        advancingDay.execute(farm, player, calendar);
                        Save.execute(saveFile, player, calendar, farm, shop);
                        break;
                }
            }

            catch (Exception e) {
                System.out.println("Invalid input!");
                input.nextLine();
            }
        }
    }

    public static void printMenu(Player player, Calendar calendar) {
        System.out.println();
        System.out.println("--- [ Day " + calendar.getDay() + " of " + calendar.getSeason() + " ] ---------");
        System.out.println(player.getName() + ": " + player.getMoney() + " coins / Level " + player.getLevel() + " (" + player.getXp() + "/" + player.getLEVEL_HEAD() +")");
        System.out.println();
        MainMenu.defaultMenu();
    }

    public static void changeSeason(Farm farm) {
        farm.clearAllPlots();
    }

    public static void listSeasonCrops(Calendar calendar) {
        ArrayList<Crop> available = getCrops();
        String season = calendar.getSeason();
        System.out.println("Available Crops:");

        for (int i = 0; i < available.size(); i++) {
            if (season.equals(available.get(i).getSeason())) {
                Crop crop = available.get(i);
                System.out.println((i + 1) + ". " + crop.getName() + " (" + crop.getDaysToGrow() + " days)");
            }
        }
    }

    public static ArrayList<Plot> getEmptyPlots(Farm farm) {
        ArrayList<Plot> emptyPlots = new ArrayList<>();
        for (Plot plot : farm.getAllPlots()) {
            if (plot.getCrop() == null) {
                emptyPlots.add(plot);
            }
        }
        return emptyPlots;
    }

}
