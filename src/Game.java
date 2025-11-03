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
                        System.out.println();
                        System.out.println(farm.getName() + ":");
                        describeAllPlots(farm);
                        break;
                    case 2:
                        advanceDay(farm, calendar);
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Choose a plot:");
                        for (Plot plot : allPlots) {
                            if (plot.getCrop() != null) {
                                if (!plot.checkWater()) {
                                    plot.describe();
                                }
                            }
                        }
                        System.out.print("> ");
                        int plotID2 = input.nextInt();
                        farm.getPlot(plotID2).waterCrop();
                        break;
                    case 4:
                        System.out.println();
                        listSeasonCrops(calendar);
                        System.out.println();
                        if (!listAvailablePlots(emptyPlots)) {
                            break;
                        }
                        System.out.println();
                        System.out.print("Crop: ");
                        int cropID = input.nextInt();
                        if (checkCropSeason(cropID, calendar, available)) {
                            System.out.print("Plot: ");
                            int plotID = input.nextInt();
                            farm.plantCrop(plotID, available.get(cropID - 1));
                            break;
                        }
                        System.out.println("(I thought of that)");
                        break;
                    case 5:
                        System.out.println("Choose a plot:");
                        for (Plot plot : allPlots) {
                            if (plot.getCrop() != null) {
                                if (plot.getCrop().isReadyToHarvest()) {
                                    plot.describe();
                                }
                            }
                        }
                        System.out.print("> ");
                        int plotID4 = input.nextInt();
                        farm.harvestCrop(plotID4, player);
                        break;
                    case 6:
                        System.out.println();
                        player.listItems();
                        System.out.println();
                        System.out.print("Item: ");
                        String itemName = input.next();
                        System.out.print("Quantity: ");
                        int quantity = input.nextInt();
                        sellItem(player, itemName, quantity);
                    case 7:
                        System.out.println();
                        player.listItems();
                        break;
                    case 8:
                        System.out.println();
                        listCrops();
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
        System.out.println("7. List inventory");
        System.out.println("8. Crop catalogue");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    public static void changeSeason(Farm farm) {
        farm.clearAllPlots();
    }

    public static boolean checkCropSeason(int cropID, Calendar calendar, ArrayList<Crop> available) {
        Crop crop = available.get(cropID - 1);
        if (calendar.getSeason().equals(crop.getSeason())) {
            return true;
        }
        return false;
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

    public static void listCrops() {
        ArrayList<Crop> available = getCropsList();
        System.out.println("Available Crops:");

        for (int i = 0; i < available.size(); i++) {
            Crop crop = available.get(i);
            System.out.println(crop.getName() + " - Plant in the " + crop.getSeason() + ", takes " + crop.getDaysToGrow() + " days to grow");
        }
        System.out.println();
    }

    public static void sellItem(Player player, String itemName, int quantity) {
        Item item = findItem(player, itemName);

        if (item == null) {
            System.out.println("You don't have that item!");
            return;
        }

        if (item.getQuantity() < quantity) {
            System.out.println("Not enough " + itemName + " to sell!");
            return;
        }

        int totalValue = item.getValue() * quantity;
        player.addMoney(totalValue);
        player.removeItem(item, quantity);

        System.out.println("Sold " + quantity + " " + itemName + " for " + totalValue + " coins!");
    }


    public static Item findItem(Player player, String itemName) {
        for (Item item : player.inventory) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }


    public static void describeAllPlots(Farm farm) {
        ArrayList<Plot> allPlots = farm.getAllPlots();
        for (Plot plot : allPlots) {
            plot.describe();
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

    public static boolean listAvailablePlots(ArrayList<Plot> emptyPlots) {
        if (emptyPlots.isEmpty()) {
            System.out.println("No plots available!");
            return false;
        }
        System.out.println("Available Plots:");
        for (Plot plot : emptyPlots) {
            System.out.println("Plot " + plot.getPlotID());
        }
        return true;
    }

    public static ArrayList<Crop> getCropsList() {
        return CropCatalogue.getCrops();
    }

    public static void advanceDay(Farm farm, Calendar calendar) {
        for (Plot plot : farm.getAllPlots()){
            plot.advanceDay();
        }

        calendar.advanceDay();
        System.out.println();
        System.out.println("Day " + calendar.getDay() + " of " + calendar.getSeason());
    }
}
