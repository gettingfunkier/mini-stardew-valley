package main.java;

import main.java.items.Crop;
import main.java.menus.StartMenu;
import main.java.menus.SubMenu;
import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Shop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static main.java.catalogues.CropCatalogue.getCrops;

public class Start {
    public static void setUp() {

        Scanner input = new Scanner(System.in);
        StartMenu.startMenu();

        try {
            final int start = input.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Invalid input");
        }

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

    }

    public static GameState startGame() {
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Name your farm: ");
        String farmName = input.next();

        Player player = new Player(name, 0);
        Farm farm = new Farm(farmName + " Farm", 5);
        Shop shop = new Shop();
        Calendar calendar = new Calendar();

        ArrayList<Crop> available = getCrops();

        return new GameState(player, farm, shop, calendar, available);
    }
}
