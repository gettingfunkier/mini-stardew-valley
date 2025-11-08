package main.java;

import java.util.ArrayList;

public class CropCatalogue {
    private static ArrayList<Crop> crops = new ArrayList<>();

    static {
        crops.add(new Crop("Parsnip", 3, 21, "Spring"));
        crops.add(new Crop("Kale", 4, 27, "Spring"));
        crops.add(new Crop("Cauliflower", 7, 75, "Spring"));
        crops.add(new Crop("Strawberry", 5, 33, "Summer"));
        crops.add(new Crop("Melon", 8, 81, "Summer"));
        crops.add(new Crop("Radish", 3, 24, "Summer"));
        crops.add(new Crop("Tomato", 5, 41, "Summer"));
        crops.add(new Crop("Wheat", 1, 10, "Summer"));
        crops.add(new Crop("Cranberry", 5, 33, "Fall"));
        crops.add(new Crop("Eggplant", 6, 51, "Fall"));
        crops.add(new Crop("Pumpkin", 11, 161, "Fall"));
        crops.add(new Crop("Amaranth", 5, 37, "Fall"));
        crops.add(new Crop("Snowfruit", 24, 595, "Winter"));
    }

    public static ArrayList<Crop> getCrops() {
        return crops;
    }

    public static Crop getCrop(int index) {
        return crops.get(index);
    }

}
