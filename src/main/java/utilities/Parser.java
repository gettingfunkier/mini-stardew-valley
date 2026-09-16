package main.java.utilities;

import main.java.items.Crop;
import main.java.items.Item;

public class Parser {

    public static String parseString(String line) {
        return line.split(": ")[1];
    }

    public static int parseInt(String line) {
        return Integer.parseInt(parseString(line));
    }

    public static String[] parseItem(String line) {
        return parseString(line).split(", ");
    }

    public static int parsePlotID() {
        String line = "";
        return line.charAt(5);
    }

    public static Crop parsePlotCrop() {
        // RETURN PLOT CROP
        String line = "";

        String[] parse = line.split(",");
        String cropID = parse[1];

        //GET CROP FROM ITEMDICT & CREATE INSTANCE WITH CROPID

        return null;
    }

}
