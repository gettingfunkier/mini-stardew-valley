package main.java;

public class Calendar {
    String[] seasons = {"Spring", "Summer", "Fall", "Winter"};
    private int day;
    private String season;
    private int seasonIndex;

    public Calendar() {
        this.day = 1;
        this.seasonIndex = 0;
        this.season = seasons[seasonIndex];
    }

    public void advanceDay() {
        day++;
        if (day > 28) {
            day = 1;
            seasonIndex = (seasonIndex + 1) % seasons.length;
            season = seasons[seasonIndex];
        }
    }

    public int getDay() {
        return day;
    }

    public String getSeason() {
        return season;
    }
}
