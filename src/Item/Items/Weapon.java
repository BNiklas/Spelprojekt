package Item.Items;

import Item.Item;

public class Weapon extends Item {

    private int attackValue;

    public Weapon() {
        this.attackValue = 0;
    }

    public Weapon(int x, int y, char look, int value, String name, int attackValue) {
        super(x, y, look, value, name);
        this.attackValue = attackValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    @Override
    public String toString() {
        return "Sword" + "(+" + getAttackValue() + ")";
    }
}
