package GameObject;

import Item.Item;

public class Player extends Character {
    private int xWantedChange;
    private int yWantedChange;

    public Player(int x, int y, char look) {
        super(x, y, look, false);
    }

    @Override
    public void onLoop() {
        super.onLoop();

        if (xWantedChange != 0 || yWantedChange != 0) {
            move(xWantedChange, yWantedChange);
            xWantedChange = 0;
            yWantedChange = 0;
        }
    }

    public void onMove(int changeX, int changeY) {
        xWantedChange = changeX;
        yWantedChange = changeY;
    }

    @Override
    public void onCollide(GameObject object) {
        System.out.println("colloisio");
        super.onCollide(object);
        System.out.println("after sup");
        if (object instanceof Item) {
            this.inventory.add(((Item) object).pickUp());
            System.out.println(object);
        }
    }
}
