package GameObject;

public class Character extends GameObject {
    private int speed;
    private int health;
    private int stamina;

    protected Character(int x, int y, char look) {
        super(x, y, look, false);
        stamina = 9;
        health = 9;
    }

    protected Character(int x, int y, char look, boolean traversable) {
        super(x, y, look, traversable);
    }

    protected int getSpeed(){
        return speed;
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
}
