package main.java.inputs;

import main.java.Calendar;
import main.java.items.Crop;
import main.java.Farm;
import main.java.Plot;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.Game.listSeasonCrops;

public class PlantInput {
    public boolean execute(Farm farm, Calendar calendar, ArrayList<Plot> emptyPlots, ArrayList<Crop> available, Scanner input) {
        System.out.println();
        listSeasonCrops(calendar);
        System.out.println();
        if (!listAvailablePlots(emptyPlots)) {
            return false;
        }
        System.out.println();
        System.out.print("Crop: ");
        int cropID = input.nextInt();
        if (checkCropSeason(cropID, calendar, available)) {
            System.out.print("Plot: ");
            int plotID = input.nextInt();
            farm.plantCrop(plotID, available.get(cropID - 1));
            return true;
        }
        System.out.println("(I thought of that)");
        return false;
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

    public static boolean checkCropSeason(int cropID, Calendar calendar, ArrayList<Crop> available) {
        Crop crop = available.get(cropID - 1);
        if (calendar.getSeason().equals(crop.getSeason())) {
            return true;
        }
        return false;
    }
}
