package GameObject;

import java.util.ArrayList;
import java.util.List;
import Item.Item;

public class Character extends GameObject {
    private int speed;
    private List<Item> inventory;

    protected Character(int x, int y, char look) {
        super(x, y, look, false);
        inventory = new ArrayList<>();
    }

    protected Character(int x, int y, char look, boolean traversable) {
        super(x, y, look, traversable);
        inventory = new ArrayList<>();
    }

    protected int getSpeed(){
        return speed;
    }
    protected List<Item> getInventory(){
        return inventory;
    }
    protected void takeItem(Item item){
        inventory.add(item);
        item.pickUp();
    }
    protected void setSpeed(int speed){
        if(speed < 0){
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }
}
