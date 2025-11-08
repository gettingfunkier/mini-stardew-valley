package main.java;

public class Crop {
    private String name;
    private int daysToGrow;
    private int currentDay;
    private int value;
    private String season;

    public Crop(String name, int daysToGrow, int value, String season) {
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.value = value;
        this.currentDay = 0;
        this.season = season;
    }

    public Crop(Crop other) {
        this.name = other.name;
        this.daysToGrow = other.daysToGrow;
        this.value = other.value;
        this.currentDay = 0;
        this.season = other.season;
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

    public String getSeason() {
        return season;
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
