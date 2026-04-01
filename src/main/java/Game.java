package main.java;

import main.java.inputs.*;
import main.java.items.Crop;
import main.java.menus.SubMenu;
import main.java.states.*;
import main.java.writers.Save;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.writers.Start.setUp;
import static main.java.menus.MainMenu.defaultMenu;
import static main.java.states.Plot.clearAllPlots;

public class Game {
    public static void main(String[] args) {

        Shell game = setUp();
        mainMenu(game.saveSlot, game.player, game.farm, game.shop, game.calendar, game.available);

    }


    public static void mainMenu(int saveFile, Player player, Farm farm, Shop shop, Calendar calendar, ArrayList<Crop> available) {
        String season = calendar.getSeason();

        while (true) {
            Scanner input = new Scanner(System.in);
            defaultMenu(player, calendar);

            ArrayList<Plot> allPlots = farm.getAllPlots();
            ArrayList<Plot> emptyPlots = Plot.getEmptyPlots(farm);

            if (!calendar.getSeason().equals(season)) {
                clearAllPlots(farm);
                season = calendar.getSeason();
            }

            try {
                Switch.Switch(saveFile, input, player, calendar, farm, shop, allPlots, emptyPlots, available);
            }

            catch (Exception e) {
                System.out.println("Invalid input!");
                input.nextLine();
            }
        }
    }

}
