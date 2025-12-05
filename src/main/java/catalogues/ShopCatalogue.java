package main.java.catalogues;

import main.java.enums.ItemType;
import main.java.items.SellableItem;

import java.util.ArrayList;

public class ShopCatalogue {
    private static ArrayList<SellableItem> shopCatalogue = new ArrayList<>();

    static {
        shopCatalogue.add(new SellableItem("Rug", ItemType.DECOR, 40));
        shopCatalogue.add(new SellableItem("Latte", ItemType.COFFEE, 255));
        shopCatalogue.add(new SellableItem("Wristwatch", ItemType.WEARABLE, 1790));
    }

    public static ArrayList<SellableItem> getShopCatalogue() {
        return shopCatalogue;
    }
}
