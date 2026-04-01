package main.java.run;

import main.java.inputs.*;
import main.java.items.Crop;
import main.java.menus.SubMenu;
import main.java.states.*;
import main.java.writers.Save;

import java.util.ArrayList;
import java.util.Scanner;

public class Switch {


    public static void Switch(int saveFile, Scanner input, Player player, Calendar calendar, Farm farm, Shop shop, ArrayList<Plot> allPlots, ArrayList<Plot> emptyPlots, ArrayList<Crop> available) {
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
}
