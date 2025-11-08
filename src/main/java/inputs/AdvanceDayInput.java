package main.java.inputs;

import main.java.Calendar;
import main.java.Farm;
import main.java.Plot;

import java.util.ArrayList;

public class AdvanceDayInput {
    public void execute(Farm farm, Calendar calendar) {
        this.advanceDay(farm, calendar);
    }

    public void advanceDay(Farm farm, Calendar calendar) {
        for (Plot plot : farm.getAllPlots()){
            plot.advanceDay();
        }

        calendar.advanceDay();
        System.out.println();
        System.out.println("Day " + calendar.getDay() + " of " + calendar.getSeason());
    }
}
