package main.java.inputs;

import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Plot;

import java.util.ArrayList;
import java.util.Scanner;

public class HarvestInput {
    public void execute(ArrayList<Plot> allPlots, Farm farm, Player player, Scanner input) {
        System.out.println();
        boolean readyPlotExists = readyPlotExists(allPlots);
        if (!readyPlotExists) {
            System.out.println("You don't have any plots ready to harvest yet.");
            return;
        }

        showReadyPlots(allPlots);
        isReady(player, farm, input);
    }

    public boolean readyPlotExists(ArrayList<Plot> allPlots) {
        for (Plot plot : allPlots) {
            if (plot.getCrop() != null) {
                if (plot.getCrop().isReadyToHarvest()) {
                    return true;
                }
            }
        }

        return false;
    }

    public void showReadyPlots(ArrayList<Plot> allPlots) {
        for (Plot plot : allPlots) {
            if (plot.getCrop() != null) {
                if (plot.getCrop().isReadyToHarvest()) {
                    plot.describe();
                }
            }
        }
    }

    public void isReady(Player player, Farm farm, Scanner input) {
        System.out.println();
        System.out.println("Choose a plot:");
        System.out.print("> ");
        int plotID4 = input.nextInt();
        System.out.println();
        farm.harvestCrop(plotID4, player);
        player.addXp(45);
    }
}
