public class Plot {
    private int plotID;
    private boolean isWatered;
    private Crop crop;

    public Plot(int plotID) {
        this.plotID = plotID;
        this.isWatered = false;
        this.crop = null;
    }

    public boolean isEmpty() {
        return crop == null;
    }

    public int getPlotID() {
        return plotID;
    }

    public void plantCrop(Crop crop) {
        this.crop = crop;
    }

    public Crop getCrop() {
        return crop;
    }

    public Crop harvestCrop() {
        Crop harvested = crop;
        crop.resetCurrentDay();
        crop = null;
        return harvested;
    }

    public void clearPlot() {
        this.crop = null;
    }

    public boolean waterCrop() {
        if (this.crop != null) {
            isWatered = true;
            System.out.println(crop.getName() + " has been watered!");
            return isWatered;
        } else {
            System.out.println("Plot is empty!");
            return false;
        }
    }

    public boolean checkWater() {
        if (this.crop != null) {
            return isWatered;
        } return true;
    }

    public void advanceDay() {
        if (!isEmpty()) {
            if (isWatered) {
                crop.addCurrentDay();
            }
        } isWatered = false;
    }

    public void describe() {
        if (isEmpty()) {
            System.out.println("Plot " + plotID + " is empty.");

        } else {
            System.out.println("Plot " + plotID + " has " + crop.getName() +
                    " (" + crop.getCurrentDay() + "/" + crop.getDaysToGrow() + " days)");

        }
    }

}
