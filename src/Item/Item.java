package Item;

import GameObject.GameObject;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Item extends GameObject {
    private int value;
    private String name;
    private boolean onGround;

    public Item() {
        super(0, 0, 'I', true);
        this.name="";
        this.value = 0;
        onGround = false;
    }

    public Item(int value, String name) {
        super(0, 0, 'I', true);
        setValue(value);
        this.name = name;
    }
    public boolean isOnGround(){
        return onGround;
    }
    public void pickUp(){
        onGround = false;
    }

    public Item(int x, int y, char look, int value, String name) {
        super(x, y, look, true);
        this.value = value;
        this.name = name;
    }

    public Item(int x, int y, char look, Terminal.Color color, int value, String name) {
        super(x, y, look, color, true);
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

    public String toString(){
        return name + " Value: " + value;
    }
}
