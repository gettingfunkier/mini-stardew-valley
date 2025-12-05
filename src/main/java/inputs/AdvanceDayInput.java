package main.java.inputs;

import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Plot;

public class AdvanceDayInput {
    public void execute(Farm farm, Player player, Calendar calendar) {
        this.advanceDay(farm, player, calendar);
    }

    public void advanceDay(Farm farm, Player player, Calendar calendar) {
        for (Plot plot : farm.getAllPlots()){
            plot.advanceDay();
        }

        calendar.advanceDay();
        player.addXp(10);

        System.out.println();
        System.out.println("Day " + calendar.getDay() + " of " + calendar.getSeason());
    }
}
