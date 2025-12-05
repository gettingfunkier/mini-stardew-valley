package main.java.inputs;

import main.java.Farm;
import main.java.Plot;
import main.java.Calendar;

import java.util.ArrayList;

public class CheckPlotsInput {
    public void execute(Farm farm) {
        System.out.println();
        System.out.println(farm.getName() + ":");
        farm.listPlots();
    }
}
