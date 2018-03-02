package GameObject.Characters;

import GameObject.GameObject;

abstract public class Chaser extends Character {
    GameObject target;

    public Chaser(int x, int y, char look) {
        super(x, y, look);
    }

    public Chaser(int x, int y, char look, boolean traversable) {
        super(x, y, look, traversable);
    }

    public void updateChaseTarget(GameObject target) {
        this.target = target;
    }
}