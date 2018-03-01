package GameObject;

abstract public class Chaser extends Character {
    GameObject target;

    public Chaser(int x, int y, char look) {
        super(x, y, look);
    }

    public void updateChaseTarget(GameObject target) {
        this.target = target;
    }
}