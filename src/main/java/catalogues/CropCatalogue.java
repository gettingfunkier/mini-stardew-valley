package main.java.catalogues;

import main.java.items.Crop;

import java.util.ArrayList;

public class CropCatalogue {
    private final static ArrayList<Crop> crops = new ArrayList<>();

    static {
        crops.add(new Crop("CROP_parsnip", "Parsnip", 3, 21, "Spring"));
        crops.add(new Crop("CROP_kale", "Kale", 4, 27, "Spring"));
        crops.add(new Crop("CROP_cauliflower", "Cauliflower", 7, 75, "Spring"));
        crops.add(new Crop("CROP_strawberry", "Strawberry", 5, 33, "Summer"));
        crops.add(new Crop("CROP_melon", "Melon", 8, 81, "Summer"));
        crops.add(new Crop("CROP_radish", "Radish", 3, 24, "Summer"));
        crops.add(new Crop("CROP_tomato", "Tomato", 5, 41, "Summer"));
        crops.add(new Crop("CROP_wheat", "Wheat", 1, 10, "Summer"));
        crops.add(new Crop("CROP_cranberry", "Cranberry", 5, 33, "Fall"));
        crops.add(new Crop("CROP_eggplant", "Eggplant", 6, 51, "Fall"));
        crops.add(new Crop("CROP_pumpkin", "Pumpkin", 11, 161, "Fall"));
        crops.add(new Crop("CROP_amaranth", "Amaranth", 5, 37, "Fall"));
        crops.add(new Crop("CROP_snowfruit", "Snowfruit", 24, 595, "Winter"));
    }

    public static ArrayList<Crop> getCrops() {
        return crops;
    }

    public static Crop getCrop(int index) {
        return crops.get(index);
    }

}
