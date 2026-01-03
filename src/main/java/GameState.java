package main.java;

import main.java.items.Crop;
import main.java.states.Calendar;
import main.java.states.Farm;
import main.java.states.Player;
import main.java.states.Shop;

import java.util.ArrayList;

public class GameState {
    public int saveSlot;
    public Player player;
    public Farm farm;
    public Shop shop;
    public Calendar calendar;
    public ArrayList<Crop> available;

    public GameState(int saveFile, Player player, Farm farm, Shop shop, Calendar calendar, ArrayList<Crop> available) {
        this.saveSlot = saveFile;
        this.player = player;
        this.farm = farm;
        this.shop = shop;
        this.calendar = calendar;
        this.available = available;
    }
}
