package main.java.menus;

import main.java.writers.Load;

public class StartMenu {
    public static void startMenu() {
        System.out.println();
        System.out.println(" █▄ ▄█ █ █▄ █ █   ▄▀▀ ▀█▀ ▄▀▄ █▀▄ █▀▄ ██▀ █   █   █ █ ▄▀▄ █   █   ██▀ ▀▄▀");
        System.out.println(" █ ▀ █ █ █ ▀█ █   ▄██  █  █▀█ █▀▄ █▄▀ █▄▄ ▀▄▀▄▀   ▀▄▀ █▀█ █▄▄ █▄▄ █▄▄  █ ");
        System.out.println(" ----- - ---- -   --- --- --- --- --- --- -----   --- --- --- --- --- ---");
        System.out.println("                                      > Code by gettingfunkier in 2025 <3");
        System.out.println();
        System.out.println(" ⎯⎯⎯  1. START GAME");
        System.out.println(" ⎯⎯⎯  2. Load Save ");
        System.out.println();
        Load.loadSave(1);
        System.out.println();
        System.out.print("> ");
    }
}
