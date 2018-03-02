package Item;

import GameObject.GameObject;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Item extends GameObject {
    private int value;
    private String name;
    private boolean onGround = true;

    public Item() {
        this(0, 0, 'I', Terminal.Color.WHITE, 0, "");
    }

    public Item(int x, int y, char look, int value, String name) {
        this(x, y, look, Terminal.Color.WHITE, value, name);
    }

    public Item(int x, int y, char look, Terminal.Color color, int value, String name) {
        super(x, y, look, color, true);
        this.value = value;
        this.name = name;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public Item pickUp() {
        onGround = false;
        return this;
    }


    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Value: " + value;
    }
}
