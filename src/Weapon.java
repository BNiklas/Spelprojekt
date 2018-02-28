public class Weapon extends Item {

    private int attackValue;

    public Weapon(){
        this.attackValue=0;
    }

    public Weapon(int value, String name, int attackValue) {
        super(value, name);
        this.attackValue = attackValue;
    }

}
