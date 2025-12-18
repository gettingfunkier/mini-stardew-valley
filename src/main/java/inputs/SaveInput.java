package main.java.inputs;

import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.writers.Save;

public class SaveInput {
    public static void execute(int SAVE_FILE, Player player, Calendar calendar, Farm farm) {
        Save.playerToFile(SAVE_FILE, player);
        Save.calendarToFile(SAVE_FILE, calendar);
        Save.farmToFile(SAVE_FILE, farm);
    }
}
