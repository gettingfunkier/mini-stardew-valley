package main.java.states;

import main.java.enums.PlotState;
import main.java.items.Crop;

public class Plot {
    private int plotID;
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
        return crop == null;
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

    public Crop harvestCrop() {
        Crop harvested = crop;
        crop.resetCurrentDay();
        crop = null;
        state = PlotState.EMPTY;
        return harvested;
    }

    public void clearPlot() {
        this.crop = null;
        this.state = PlotState.EMPTY;
    }

    public void waterCrop() {
        if (this.crop != null) {
            isWatered = true;
            System.out.println(crop.getName() + " has been watered!");
            state = PlotState.WATERED;
        } else {
            System.out.println("Plot is empty!");
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

}
