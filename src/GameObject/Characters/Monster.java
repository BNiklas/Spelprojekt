package GameObject.Characters;


import java.util.Random;

import GameObject.GameObject;

public class Monster extends Chaser {
    private String type;

    public Monster(int x, int y, char look) {
        super(x, y, look, true);

        Random rand = new Random();
        String[] types = {"Skeleton", "Goblin"};
        this.type = types[rand.nextInt(2)];
        setSpeed(1);
    }

    @Override
    public void onLoop() {
        super.onLoop();

        if (lookFor(target)) {
            chase(target);
        }
    }

    private boolean lookFor(GameObject object) {
        int searchRange = 5;
        if (object == null) {
            return false;
        }
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
        } else if (this.getY() > object.getY()) {
            move(0, -this.getSpeed());
        }
    }

    public String getType() {
        return type;
    }
}