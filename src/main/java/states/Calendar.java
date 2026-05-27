package main.java.states;

public class Calendar {
    final String[] seasons = {"Spring", "Summer", "Fall", "Winter"};
    private int day;
    private int year;
    private int seasonIndex;
    private String season;

    public Calendar() {
        this.day = 1;
        this.year = 1;
        this.seasonIndex = 0;
        this.season = seasons[seasonIndex];
    }

    public void advanceDay() {
        day++;
        if (day > 28) {
            day = 1;

            if (season.equals("Winter")) {
                advanceYear();
            }

            advanceSeason();
        }
    }

    public void advanceSeason() {
        seasonIndex = (seasonIndex + 1) % seasons.length;
        season = seasons[seasonIndex];
    }

    public void advanceYear() {
        year++;
    }

    public int getDay() {
        return day;
    }

    public String getSeason() {
        return season;
    }

    public int getSeasonIndex() {
        return seasonIndex;
    }
}
