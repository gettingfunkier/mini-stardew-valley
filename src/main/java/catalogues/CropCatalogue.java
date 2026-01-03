package main.java.catalogues;

import main.java.items.Crop;

import java.util.ArrayList;

public class CropCatalogue {
    private final static ArrayList<Crop> crops = new ArrayList<>();

    static {
        crops.add(new Crop("CROP_parsnip", "Parsnip", 21, 3, "Spring"));
        crops.add(new Crop("CROP_kale", "Kale", 27, 4, "Spring"));
        crops.add(new Crop("CROP_cauliflower", "Cauliflower", 75, 7, "Spring"));
        crops.add(new Crop("CROP_strawberry", "Strawberry", 33, 5, "Summer"));
        crops.add(new Crop("CROP_melon", "Melon", 81, 8, "Summer"));
        crops.add(new Crop("CROP_radish", "Radish", 24, 3, "Summer"));
        crops.add(new Crop("CROP_tomato", "Tomato", 41, 5, "Summer"));
        crops.add(new Crop("CROP_wheat", "Wheat", 10, 1, "Summer"));
        crops.add(new Crop("CROP_cranberry", "Cranberry", 34, 5, "Fall"));
        crops.add(new Crop("CROP_eggplant", "Eggplant", 51, 6, "Fall"));
        crops.add(new Crop("CROP_pumpkin", "Pumpkin", 161, 11, "Fall"));
        crops.add(new Crop("CROP_amaranth", "Amaranth", 37, 5, "Fall"));
        crops.add(new Crop("CROP_snowfruit", "Snowfruit", 595, 24, "Winter"));
    }

    public static ArrayList<Crop> getCrops() {
        return crops;
    }

    public static Crop getCrop(int index) {
        return crops.get(index);
    }
}
