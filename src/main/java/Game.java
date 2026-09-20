package main.java;

import main.java.items.Crop;
import main.java.runtime.Content;
import main.java.runtime.Shell;
import main.java.runtime.Switch;
import main.java.states.*;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.prints.Errors.PrintExceptionError;
import static main.java.runtime.Start.setUp;
import static main.java.menus.MainMenu.defaultMenu;

public class Game {
    public static void main(String[] args) {
        try {
        Content.registerItems();

        Shell game = setUp();
        mainMenu(game.saveSlot, game.player, game.farm, game.shop, game.calendar, game.available);
        }
        catch (Exception e) {
            PrintExceptionError(e);
            System.exit(0);
        }
    }

    public static void mainMenu(int saveFile, Player player, Farm farm, Shop shop, Calendar calendar, ArrayList<Crop> available) {
        String season;

        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                defaultMenu(player, calendar);

                season = calendar.getSeason();

                ArrayList<Plot> allPlots = farm.getAllPlots();
                ArrayList<Plot> emptyPlots = Plot.getEmptyPlots(farm);

                if (!Switch.SwitchMain(saveFile, input, player, calendar, season, farm, shop, allPlots, emptyPlots, available)) {
                    System.exit(0);
                }
            }
            catch (Exception e) {
                PrintExceptionError(e);
            }
        }
    }

}
