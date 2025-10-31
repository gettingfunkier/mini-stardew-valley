import java.util.ArrayList;

public class CropCatalogue {
    private static ArrayList<Crop> crops = new ArrayList<>();

    static {
        crops.add(new Crop("Parsnip", 3, 21));
        crops.add(new Crop("Cauliflower", 7, 75));
        crops.add(new Crop("Melon", 5, 37));
    }

    public static ArrayList<Crop> getCrops() {
        return crops;
    }

    public static Crop getCrop(int index) {
        return crops.get(index);
    }

}
