package main.java.inputs;

import main.java.items.Crop;

import java.util.ArrayList;

import static main.java.Game.getCropsList;

public class CropCatalogueInput {
    public void execute() {
        System.out.println();
        listCrops();
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
}
