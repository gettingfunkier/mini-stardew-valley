package main.java.inputs;

import main.java.Calendar;
import main.java.Farm;
import main.java.Plot;

import java.util.ArrayList;
import java.util.Scanner;

public class WaterInput {
    public void execute(Farm farm, ArrayList<Plot> allPlots, Scanner input) {
        this.choosePlot(farm, allPlots);
        System.out.print("> ");
        int plotID2 = input.nextInt();
        farm.getPlot(plotID2).waterCrop();
    }

    public void choosePlot(Farm farm, ArrayList<Plot> allPlots) {
        System.out.println();
        System.out.println("Choose a plot:");
        for (Plot plot : allPlots) {
            if (plot.getCrop() != null) {
                if (!plot.checkWater()) {
                    plot.describe();
                }
            }
        }
    }
}
