package Room;

import GameObject.*;
import Item.Valuable;
import Item.Weapon;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<GameObject> gameObjects;
    Player player;

    private static final int SCREEN_WIDTH = 70;
    private static final int SCREEN_HEIGHT = 30;


    public Room(Player player) {
        this.player = player;
        this.gameObjects = new ArrayList<>();
        gameObjects.add(player);
    }
    public Room(Player player, List<GameObject> gameObjects){

    }
    public static int getScreenwidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenheight() {
        return SCREEN_HEIGHT;
    }

    public void onInit() {
        gameObjects.add(new Monster(10, 10, 'M'));
    }

    public void onLoop() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Chaser) {
                ((Chaser) gameObject).updateChaseTarget(player);
            }
            if (gameObject instanceof LoopUpdateable) {
                ((LoopUpdateable) gameObject).onLoop();
            }
        }
    }

    public void onDraw(Terminal terminal) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onDraw(terminal);
        }
    }

    public void reDraw() {
        for (GameObject gameObject : gameObjects) {
            gameObject.needsToDraw();
        }
    }

    public List<Collision> checkCollisions() {
        List<Collision> collisions = new ArrayList<>();
        for (GameObject gameObject : gameObjects) {
            for (GameObject innerObject : gameObjects) {
                if (gameObject == innerObject) {
                    continue;
                }
                if (gameObject.getX() == innerObject.getX() && gameObject.getY() == innerObject.getY()) {
                    collisions.add(new Collision(gameObject, innerObject));
                }
            }
        }
        return collisions;
    }

    private void addRandomItems(List<GameObject> gameObjects){
        gameObjects.addAll(Valuable.getRandomValuables(3));
        gameObjects.addAll(Weapon.getRandomWeapons(2));
    }
    private void addMonsters(List<GameObject> gameObjects){
        gameObjects.addAll(Monster.getRandomAmountOfMonsters(4));
    }
}
