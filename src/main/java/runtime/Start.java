package main.java.runtime;

import main.java.items.Crop;
import main.java.menus.StartMenu;
import main.java.menus.SubMenu;
import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Shop;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.catalogues.CropCatalogue.getCrops;
import static main.java.runtime.Switch.SwitchStart;
import static main.java.writers.Load.*;

public class Start {
    public static Shell setUp() {

        StartMenu.startMenu();
        Scanner inputMain = new Scanner(System.in);
        
        return SwitchStart(inputMain);
    }

    public static int defSlot() {

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

        inputSlot.close();
        return saveFile;
    }

    public static Shell startGame(int saveSlot) {
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Name your farm: ");
        String farmName = input.next();

        Player player = new Player(name, 5);
        Farm farm = new Farm(farmName + " Farm", 5);
        Calendar calendar = new Calendar();
        Shop shop = new Shop();

        input.close();

        ArrayList<Crop> available = getCrops();
        return new Shell(saveSlot, player, farm, shop, calendar, available);
    }

    public static Shell loadGame(int saveSlot) {
        System.out.println();

        Player player = loadPlayer(saveSlot);
        Farm farm = loadFarm(saveSlot);
        Calendar calendar = loadCalendar(saveSlot);
        Shop shop = new Shop();

        ArrayList<Crop> available = getCrops();
        return new Shell(saveSlot, player, farm, shop, calendar, available);
    }
}