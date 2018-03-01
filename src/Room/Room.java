package Room;

import GameObject.*;
import Item.Valuable;
import Item.Weapon;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private List<GameObject> gameObjects;
    private Player player;

    public boolean wantsBackPortal = true;

    private static final int SCREEN_WIDTH = 70;
    private static final int SCREEN_HEIGHT = 30;


    public Room() {
        this.gameObjects = new ArrayList<>();
        Random rand = new Random();
        gameObjects.add(new Door(rand.nextInt(SCREEN_WIDTH - 2) + 1, rand.nextInt(SCREEN_HEIGHT - 2) + 1));
        this.addMonsters(gameObjects);
        this.addRandomItems(gameObjects);
        this.addWalls(gameObjects);
        this.addHills(gameObjects);
        this.addLakes(gameObjects);

    }

    public void addBackPortal(Room oldRoom) {
        Random rand = new Random();
        wantsBackPortal = false;
        gameObjects.add(new Door(rand.nextInt(SCREEN_WIDTH - 2) + 1, rand.nextInt(SCREEN_HEIGHT - 2) + 1, Terminal.Color.BLUE, oldRoom));
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }


    public void onLoop() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Chaser) {
                ((Chaser) gameObject).updateChaseTarget(player);
            }

            gameObject.onLoop();
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
                boolean alreadyExists = false;
                if (gameObject == innerObject) {
                    continue;
                }
                if (gameObject.getX() == innerObject.getX() && gameObject.getY() == innerObject.getY()) {
                    for (Collision collision : collisions) {
                        if(collision.contains(gameObject, innerObject)) {
                            alreadyExists = true;
                        }
                    }
                    if(!alreadyExists) {
                        collisions.add(new Collision(gameObject, innerObject));
                    }
                }
            }
        }
        return collisions;
    }

    public void onEnter(Player player) {
        gameObjects.add(player);
        this.player = player;
        reDraw();
    }

    public Player onExit() {
        gameObjects.remove(player);
        Player temp = this.player;
        this.player = null;
        return temp;
    }

    private void addRandomItems(List<GameObject> gameObjects){
        gameObjects.addAll(Valuable.getRandomValuables(6));
        gameObjects.addAll(Weapon.getRandomWeapons(2));
    }
    private void addMonsters(List<GameObject> gameObjects){
        gameObjects.addAll(Monster.getRandomAmountOfMonsters(4));
    }

    private void addHills(List<GameObject> gameObjects){
        gameObjects.addAll(Hill.getHills());
    }

    private void addWalls(List<GameObject> gameObjects){
        gameObjects.addAll(Wall.getWalls());
    }

    private void addLakes(List<GameObject> gameObjects){ gameObjects.addAll(Lake.getLake()); }
}
