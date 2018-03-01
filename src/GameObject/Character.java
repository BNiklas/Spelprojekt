package GameObject;

public class Character extends GameObject {
    //TODO Add character specific things
    private int speed;

    protected Character(int x, int y, char look) {
        super(x, y, look);
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
