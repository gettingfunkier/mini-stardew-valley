package main.java.states;

import main.java.enums.PlotState;
import main.java.items.Crop;

import java.util.ArrayList;

public class Plot {
    private final int plotID;
    private boolean isWatered;
    private Crop crop;
    private PlotState state;

    public Plot(int plotID) {
        this.plotID = plotID;
        this.isWatered = false;
        this.crop = null;
        this.state = PlotState.EMPTY;
    }

    public boolean isEmpty() {
        return state == PlotState.EMPTY;
    }

    public int getPlotID() {
        return plotID;
    }

    public void plantCrop(Crop crop) {
        this.crop = crop;
        this.state = PlotState.DRY;
    }

    public Crop getCrop() {
        return crop;
    }

    public PlotState getState() {
        return state;
    }

    public void harvestCrop() {
        crop = null;
        state = PlotState.EMPTY;
    }

    public void clearPlot() {
        this.crop = null;
        this.state = PlotState.EMPTY;
    }

    public static void clearAllPlots(Farm farm) {
        farm.clearAllPlots();
    }

    public void waterCrop() {
        if (this.crop != null && this.state == PlotState.DRY) {
            isWatered = true;
            System.out.println(crop.getName() + " has been watered!");
            state = PlotState.WATERED;
        } else {
            System.out.println("Plot is either empty, ready to harvest, or already watered!");
        }
    }

    public boolean checkWater() {
        if (this.crop != null) {
            return isWatered;
        } return true;
    }

    public void advanceDay() {
        if (!isEmpty()) {
            crop.addCurrentDay();

            if (crop.isReadyToHarvest()) {
                state = PlotState.READY;
                return;
            }
            if (isWatered) {
                isWatered = false;
                state = PlotState.DRY;
            }
        }
    }

    public void describe() {
        switch (state) {
            case EMPTY:
                System.out.println("#" + plotID + " - Empty");
                break;
            case DRY:
                System.out.println("#" + plotID + " - Dry " + getCrop().getName() +
                        " (" + crop.getCurrentDay() + "/" + crop.getDaysToGrow() + " days)");
                break;
            case WATERED:
                System.out.println("#" + plotID + " - Watered " + getCrop().getName() +
                        " (" + crop.getCurrentDay() + "/" + crop.getDaysToGrow() + " days)");
                break;
            case READY:
                System.out.println("#" + plotID + " - " + getCrop().getName() +
                        " ready to harvest!");
                break;
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

}
