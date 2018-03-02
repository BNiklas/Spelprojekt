package Room;

import GameObject.GameObject;

class Collision {
    private GameObject object1;
    private GameObject object2;

    Collision(GameObject object1, GameObject object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public GameObject getObject1() {
        return object1;
    }

    public GameObject getObject2() {
        return object2;
    }

    public void alertObjects() {
        object1.onCollide(object2);
        object2.onCollide(object1);
    }

    public boolean contains(GameObject object1, GameObject object2) {
        if (this.object1 == object1 && this.object2 == object2) {
            return true;
        }
        if (this.object2 == object1 && this.object1 == object2) {
            return true;
        }
        return false;
    }
}