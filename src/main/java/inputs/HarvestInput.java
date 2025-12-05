package main.java.inputs;

import main.java.states.Farm;
import main.java.states.Player;
import main.java.Plot;

import java.util.ArrayList;
import java.util.Scanner;

public class HarvestInput {
    public void execute(ArrayList<Plot> allPlots, Farm farm, Player player, Scanner input) {
        System.out.println();
        System.out.println("Choose a plot:");
        for (Plot plot : allPlots) {
            if (plot.getCrop() != null) {
                if (plot.getCrop().isReadyToHarvest()) {
                    plot.describe();
                }
            }
        }
        System.out.print("> ");
        int plotID4 = input.nextInt();
        farm.harvestCrop(plotID4, player);
    }
}
