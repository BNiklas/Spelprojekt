package Item;

import GameObject.GameObject;

public abstract class Item extends GameObject {
    private int value;
    private String name;

    public Item() {
        super(0, 0, 'I', true);
        this.name="";
        this.value = 0;
    }

    public Item(int value, String name) {
        super(0, 0, 'I', true);
        setValue(value);
        this.name = name;
    }

    public Item(int x, int y, char look, int value, String name) {
        super(x, y, look, true);
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        if (value>=0) {
            this.value = value;
        }
        else this.value=0;
    }

    public String getName() {
        return name;
    }
}
