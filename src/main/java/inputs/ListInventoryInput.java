package main.java.inputs;

import main.java.states.Player;

public class ListInventoryInput {
    public void execute(Player player) {
        System.out.println();
        player.listItems();
    }
}
