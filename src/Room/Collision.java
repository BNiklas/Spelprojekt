package Room;

import GameObject.GameObject;

class Collision {
    private GameObject object1;
    private GameObject object2;

    public Collision(GameObject object1, GameObject object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public GameObject getObject1() {
        return object1;
    }

    public GameObject getObject2() {
        return object2;
    }

    public void alert() {
        object1.onCollide(object2);
        object2.onCollide(object1);
    }
}