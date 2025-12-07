package main.java.catalogues;

import main.java.items.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalogue {
    private static final Map<String, Item> items = new HashMap<>();

    public static void register(Item item) {
        items.put(item.getId(), item);
    }
}
