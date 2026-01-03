package main.java.catalogues;

import main.java.enums.ItemType;
import main.java.items.Sellable;

import java.util.ArrayList;

public class ShopCatalogue {
    private static ArrayList<Sellable> shopCatalogue = new ArrayList<>();

    static {
        shopCatalogue.add(new Sellable("DECOR_rug", "Rug", ItemType.DECOR, 40));
        shopCatalogue.add(new Sellable("COFFEE_latte", "Latte", ItemType.COFFEE, 255));
        shopCatalogue.add(new Sellable("WEARABLE_wristwatch", "Wristwatch", ItemType.WEARABLE, 1790));
    }

    public static ArrayList<Sellable> getShopCatalogue() {
        return shopCatalogue;
    }
}
