package GameObject;

public class Monster extends Character {
    public Monster(int x, int y, char look) {
        super(x, y, look);
        setSpeed(1);
    }


    public void onLoop(Player player) {
        if (lookFor(player)) {
            chase(player);
        }
    }

    private boolean lookFor(GameObject object) {
        int searchRange = 5;
        if (Math.abs(this.getX() - object.getX()) < searchRange && Math.abs(this.getY() - object.getY()) < searchRange) {
            return true;
        }
        return false;
    }

    private void chase(GameObject object) {
        if (this.getX() < object.getX()) {
            move(this.getSpeed(), 0);
        } else if (this.getX() > object.getX()) {
            move(-this.getSpeed(), 0);
        } else if (this.getY() < object.getY()) {
            move(0, this.getSpeed());
        } else if(this.getY() > object.getY()){
            move(0, -this.getSpeed());
        }
    }

}
