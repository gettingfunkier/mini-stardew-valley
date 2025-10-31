import java.util.ArrayList;

public class GameState {
    public Player player;
    public Farm farm;
    public Calendar calendar;
    public ArrayList<Crop> available;

    public GameState(Player player, Farm farm, Calendar calendar, ArrayList<Crop> available) {
        this.player = player;
        this.farm = farm;
        this.calendar = calendar;
        this.available = available;
    }
}
