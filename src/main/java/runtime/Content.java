package main.java.runtime;

import main.java.enums.ItemType;
import main.java.items.Crop;
import main.java.items.Item;
import main.java.items.Sellable;

import java.util.HashMap;

public class Content {

    private static final HashMap<String, Item> itemDict = new HashMap<>();

    public static void registerItems() {
        registerCrops();
        registerStartingSellableItems();
    }

    public static Item getItem(String id) {
        return itemDict.get(id);
    }

    private static void registerCrops() {
        Crop parsnip = new Crop("CROP_parsnip", "Parsnip", 21, 3, "Spring");
        Crop kale = new Crop("CROP_kale", "Kale", 27, 4, "Spring");
        Crop cauliflower = new Crop("CROP_cauliflower", "Cauliflower", 75, 7, "Spring");
        Crop strawberry = new Crop("CROP_strawberry", "Strawberry", 33, 5, "Summer");
        Crop melon = new Crop("CROP_melon", "Melon", 81, 8, "Summer");
        Crop radish = new Crop("CROP_radish", "Radish", 24, 3, "Summer");
        Crop tomato = new Crop("CROP_tomato", "Tomato", 41, 5, "Summer");
        Crop wheat = new Crop("CROP_wheat", "Wheat", 10, 1, "Summer");
        Crop cranberry = new Crop("CROP_cranberry", "Cranberry", 34, 5, "Fall");
        Crop eggplant = new Crop("CROP_eggplant", "Eggplant", 51, 6, "Fall");
        Crop pumpkin = new Crop("CROP_pumpkin", "Pumpkin", 161, 11, "Fall");
        Crop amaranth = new Crop("CROP_amaranth", "Amaranth", 37, 5, "Fall");
        Crop snowfruit = new Crop("CROP_snowfruit", "Snowfruit", 595, 24, "Winter");

        itemDict.put(parsnip.getId(), parsnip);
        itemDict.put(kale.getId(), kale);
        itemDict.put(cauliflower.getId(), cauliflower);
        itemDict.put(strawberry.getId(), strawberry);
        itemDict.put(melon.getId(), melon);
        itemDict.put(radish.getId(), radish);
        itemDict.put(tomato.getId(), tomato);
        itemDict.put(wheat.getId(), wheat);
        itemDict.put(cranberry.getId(), cranberry);
        itemDict.put(eggplant.getId(), eggplant);
        itemDict.put(pumpkin.getId(), pumpkin);
        itemDict.put(amaranth.getId(), amaranth);
        itemDict.put(snowfruit.getId(), snowfruit);
    }

    private static void registerStartingSellableItems() {
        Sellable rug = new Sellable("DECOR_rug", "Rug", ItemType.DECOR, 40);
        Sellable latte = new Sellable("COFFEE_latte", "Latte", ItemType.COFFEE, 255);
        Sellable wristwatch = new Sellable("WEARABLE_wristwatch", "Wristwatch", ItemType.WEARABLE, 1790);

        itemDict.put(rug.getId(), rug);
        itemDict.put(latte.getId(), latte);
        itemDict.put(wristwatch.getId(), wristwatch);
    }
}
