public class Crop {
    private String name;
    private int daysToGrow;
    private int currentDay;
    private int value;

    public Crop(String name, int daysToGrow, int value) {
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.value = value;
        this.currentDay = 0;
    }

    public Crop(Crop other) {
        this.name = other.name;
        this.daysToGrow = other.daysToGrow;
        this.value = other.value;
        this.currentDay = 0; // fresh plant
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getDaysToGrow() {
        return daysToGrow;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void addCurrentDay() {
        currentDay++;
        isReadyToHarvest();
    }

    public void resetCurrentDay() {
        currentDay = 0;
    }

    public boolean isReadyToHarvest() {
        if (currentDay >= daysToGrow) {
            return true;
        }
        return false;
    }
}
