public class Armor extends Item {

    private int defenceValue;

    public Armor(int value, String name, int defenceValue) {
        super(value, name);
        this.defenceValue = defenceValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }
}
