package main.java.states;

import main.java.enums.ItemType;
import main.java.items.Crop;
import main.java.items.Item;

import java.util.ArrayList;

public class Farm {
    private final String name;
    private int capacity;
    private ArrayList<Plot> plots;

    public Farm(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        plots = new ArrayList<>();

        for (int i = 1; i <= capacity; i++) {
            plots.add(new Plot(i));
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Plot getPlot(int id) {
        if (id <= 0 || id > capacity) {
            System.out.println("Invalid plot ID: " + id);
            return null;
        }

        for (Plot plot : plots) {
            if (plot.getPlotID() == id) {
                return plot;
            }
        }

        System.out.println("Plot not found.");
        return null;
    }

    public ArrayList<Plot> getAllPlots() {
        return plots;
    }

    public void clearAllPlots() {
        for (Plot plot : plots) {
            plot.clearPlot();
        }
    }

    public void plantCrop(int plotID, Crop crop) {
        Plot plot = getPlot(plotID);

        if (plot != null && plot.isEmpty()) {
            Crop newCrop = new Crop(crop);
            plot.plantCrop(newCrop);
            System.out.println("Planted " + newCrop.getName() + " on plot " + plotID);
        } else {
            System.out.println("Plot not found or occupied!");
        }
    }


    public void harvestCrop(int plotID, Player player) {
        Plot plot = getPlot(plotID);

        if (plot != null && !plot.isEmpty()) {
            Crop crop = plot.getCrop();

            if (crop.isReadyToHarvest()) {
                Item item = new Item(crop.getId(), crop.getName(), 1, ItemType.CROP, crop.getValue());
                player.addItem(item);

                plot.harvestCrop();
                plot.clearPlot();
                System.out.println(crop.getName() + " harvested!");

            } else {
                System.out.println("Crop not ready yet!");

            }
        }
    }

    public void listPlots() {
        for (Plot plot : plots) {
            plot.describe();
        }
    }
}
