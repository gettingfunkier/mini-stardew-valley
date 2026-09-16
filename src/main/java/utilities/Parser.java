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

    public static int parsePlotID(String line) {
        String key = line.split(": ")[0];
        return Integer.parseInt(key.substring(5));
    }

    public static String[] parsePlotData(String line) {
        return parseString(line).split(",");
    }
}
