package GameObject;

public class Character extends GameObject {
    private int speed;

    protected Character(int x, int y, char look) {
        super(x, y, look, false);
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
}
