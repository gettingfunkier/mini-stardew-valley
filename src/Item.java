public class Item {
    private String name;
    private String type;
    private int quantity;
    private int value;

    public Item(String name, int quantity, String type, int value) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
