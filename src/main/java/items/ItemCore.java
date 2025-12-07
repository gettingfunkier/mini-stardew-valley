package main.java.items;

import main.java.enums.ItemType;

public abstract class ItemCore {
    protected final String id;
    protected String name;
    protected ItemType type;

    public ItemCore(String id, String name, ItemType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }
}
