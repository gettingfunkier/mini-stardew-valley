package main.java;

import main.java.enums.ItemType;
import main.java.items.Crop;
import main.java.items.Sellable;

public class Content {
    public static void registerCrops() {
        new Crop("CROP_parsnip", "Parsnip", 21, 3, "Spring");
        new Crop("CROP_kale", "Kale", 27, 4, "Spring");
        new Crop("CROP_cauliflower", "Cauliflower", 75, 7, "Spring");
        new Crop("CROP_strawberry", "Strawberry", 33, 5, "Summer");
        new Crop("CROP_melon", "Melon", 81, 8, "Summer");
        new Crop("CROP_radish", "Radish", 24, 3, "Summer");
        new Crop("CROP_tomato", "Tomato", 41, 5, "Summer");
        new Crop("CROP_wheat", "Wheat", 10, 1, "Summer");
        new Crop("CROP_cranberry", "Cranberry", 33, 5, "Fall");
        new Crop("CROP_eggplant", "Eggplant", 51, 6, "Fall");
        new Crop("CROP_pumpkin", "Pumpkin", 161, 11, "Fall");
        new Crop("CROP_amaranth", "Amaranth", 37, 5, "Fall");
        new Crop("CROP_snowfruit", "Snowfruit", 595, 24, "Winter");
    }

    public static void registerStartingSellableItems() {
        new Sellable("DECOR_rug", "Rug", ItemType.DECOR, 40);
        new Sellable("COFFEE_latte", "Latte", ItemType.COFFEE, 255);
        new Sellable("WEARABLE_wristwatch", "Wristwatch", ItemType.WEARABLE, 1790);
    }
}
