package main.java.inputs;

import main.java.states.Farm;

public class CheckPlotsInput {
    public void execute(Farm farm) {
        System.out.println();
        System.out.println(farm.getName() + ":");
        farm.listPlots();
    }
}
