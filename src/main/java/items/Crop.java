package main.java.items;

import main.java.enums.ItemType;

public class Crop extends Item {
    private int daysToGrow;
    private int currentDay;
    private String season;

    public Crop(String id, String name, int value, int daysToGrow, String season) {
        super(id, name, 0, ItemType.CROP, value);
        this.daysToGrow = daysToGrow;
        this.currentDay = 0;
        this.season = season;
    }

    public Crop(Crop other) {
        super(other);
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
