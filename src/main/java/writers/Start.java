package main.java.writers;

import main.java.GameState;
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
    public static GameState setUp() {

        Scanner inputMain = new Scanner(System.in);
        StartMenu.startMenu();

        try {
            final int start = inputMain.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Invalid input");
        }

        int saveSlot = defSlot();
        return startGame(saveSlot);
    }

    private static int defSlot() {

        int saveFile;
        Scanner inputSlot = new Scanner(System.in);

        while (true) {
            SubMenu.savesMenu();

            if (!inputSlot.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input!" + "\n");
                inputSlot.next();
                continue;
            }

            saveFile = inputSlot.nextInt();

            if (saveFile < 1 || saveFile > 4) {
                System.out.println();
                System.out.println("Invalid slot! (1 to 4)" + "\n");
                continue;
            }

            break;
        }

        return saveFile;
    }

    public static GameState startGame(int saveSlot) {
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

        return new GameState(saveSlot, player, farm, shop, calendar, available);
    }
}