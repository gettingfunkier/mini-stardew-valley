package main.java;

import main.java.inputs.*;
import main.java.items.Crop;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        GameState game = startGame();
        mainMenu(game.farm, game.available, game.player, game.calendar);

    }

    public static GameState startGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Name your farm: ");
        String farmName = input.next();

        Player player = new Player(name, 0);
        Farm farm = new Farm(farmName + " Farm", 5);
        Calendar calendar = new Calendar();

        ArrayList<Crop> available = getCropsList();

        return new GameState(player, farm, calendar, available);
    }

    public static void mainMenu(Farm farm, ArrayList<Crop> available, Player player, Calendar calendar) {
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
                        CheckPlotsInput check = new CheckPlotsInput();
                        check.execute(farm);
                        break;
                    case 2:
                        AdvanceDayInput advanceDay = new AdvanceDayInput();
                        advanceDay.execute(farm, calendar);
                        break;
                    case 3:
                        WaterInput water = new WaterInput();
                        water.execute(farm, allPlots, input);
                        break;
                    case 4:
                        PlantInput plant = new PlantInput();
                        plant.execute(farm, calendar, emptyPlots, available, input);
                        break;
                    case 5:
                        HarvestInput harvest = new HarvestInput();
                        harvest.execute(allPlots, farm, player, input);
                        break;
                    case 6:
                        SellInput sell = new SellInput();
                        sell.execute(player, input);
                        break;
                    case 7:
                        ShopInput shop = new ShopInput();
                        shop.execute(player, input);
                        break;
                    case 8:
                        ListInventoryInput listInventory = new ListInventoryInput();
                        listInventory.execute(player);
                        break;
                    case 9:
                        CropCatalogueInput cropCatalogue = new CropCatalogueInput();
                        cropCatalogue.execute();
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
        System.out.println(player.getName() + ": " + player.getMoney() + " coins");
        System.out.println();
        System.out.println("Options:");
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
        System.out.print("> ");
    }

    public static void changeSeason(Farm farm) {
        farm.clearAllPlots();
    }

    public static void listSeasonCrops(Calendar calendar) {
        ArrayList<Crop> available = getCropsList();
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

    public static ArrayList<Crop> getCropsList() {
        return CropCatalogue.getCrops();
    }
}
