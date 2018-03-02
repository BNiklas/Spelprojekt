package GameObject;

import java.util.ArrayList;
import java.util.List;
import Item.Item;
import Item.Weapon;

public class Character extends GameObject {
    private int speed;
    private int health;
    private int stamina;
    private List<Item> inventory;
    private boolean isAlive;

    protected Character(int x, int y, char look) {
        this(x, y, look, false);
    }

    protected Character(int x, int y, char look, boolean traversable) {
        super(x, y, look, traversable);
        stamina = 9;
        health = 15;
        inventory = new ArrayList<>();
        isAlive = true;
    }
    public Weapon getBestWeapon(){
        Weapon weapon = new Weapon();
        int bestAttackValue = -1;
        for(Item item : inventory){
            if(item instanceof Weapon && ((Weapon) item).getAttackValue() > bestAttackValue){
                weapon = (Weapon) item;
                bestAttackValue = ((Weapon) item).getAttackValue();
            }
        }
        return weapon;
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

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void kill() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
