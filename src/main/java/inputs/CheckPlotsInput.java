package main.java.inputs;

import main.java.Farm;
import main.java.Plot;
import main.java.Calendar;

import java.util.ArrayList;

public class CheckPlotsInput {
    public void execute(Farm farm) {
        System.out.println();
        System.out.println(farm.getName() + ":");
        this.describeAllPlots(farm);
    }

    public void describeAllPlots(Farm farm) {
        ArrayList<Plot> allPlots = farm.getAllPlots();
        for (Plot plot : allPlots) {
            plot.describe();
        }
    }
}
