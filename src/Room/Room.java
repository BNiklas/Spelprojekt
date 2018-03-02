package Room;

import GameObject.*;
import GameObject.Characters.*;
import Item.Item;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private List<GameObject> gameObjects;
    private Player player;

    boolean wantsBackPortal = true;

    private static final int SCREEN_WIDTH = 70;
    private static final int SCREEN_HEIGHT = 30;


    public Room() {
        this.gameObjects = new ArrayList<>();
        this.addObjectsToRoom();
    }

    private void addObjectsToRoom() {
        Random rand = new Random();
        gameObjects.add(new Door(rand.nextInt(SCREEN_WIDTH - 2) + 1, rand.nextInt(SCREEN_HEIGHT - 2) + 1));
        gameObjects.addAll(ContentGenerator.getRandomAmountOfMonsters(4));
        gameObjects.addAll(ContentGenerator.getRandomValuables(6));
        gameObjects.addAll(ContentGenerator.getRandomWeapons(2));
        gameObjects.addAll(ContentGenerator.getWalls());
        gameObjects.addAll(ContentGenerator.getHills());
        gameObjects.addAll(ContentGenerator.getHills());
        gameObjects.addAll(ContentGenerator.getLake());
        gameObjects.addAll(ContentGenerator.getLake());
    }

    void addBackPortal(Room oldRoom) {
        Random rand = new Random();
        wantsBackPortal = false;
        gameObjects.add(new Door(rand.nextInt(SCREEN_WIDTH - 2) + 1, rand.nextInt(SCREEN_HEIGHT - 2) + 1, Terminal.Color.BLUE, oldRoom));
    }

    static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }


    public void onLoop() {
        List<GameObject> objectsToKill = new ArrayList<>();

        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Chaser) {
                ((Chaser) gameObject).updateChaseTarget(player);
            }
            if (gameObject instanceof Monster) {
                if (!((Monster) gameObject).isAlive()) {
                    objectsToKill.add(gameObject);
                }
            } else if (gameObject instanceof Item) {
                if (!((Item) gameObject).isOnGround()) {
                    objectsToKill.add(gameObject);
                }
            }

            gameObject.onLoop();
        }
        gameObjects.removeAll(objectsToKill);
    }

    public void onDraw(Terminal terminal) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onDraw(terminal);
        }
    }

    void reDraw() {
        for (GameObject gameObject : gameObjects) {
            gameObject.needsToDraw();
        }
    }

    List<Collision> checkCollisions() {
        List<Collision> collisions = new ArrayList<>();
        for (GameObject gameObject : gameObjects) {
            for (GameObject innerObject : gameObjects) {
                boolean alreadyExists = false;
                if (gameObject == innerObject) {
                    continue;
                }
                if (gameObject.getX() == innerObject.getX() && gameObject.getY() == innerObject.getY()) {
                    for (Collision collision : collisions) {
                        if (collision.contains(gameObject, innerObject)) {
                            alreadyExists = true;
                        }
                    }
                    if (!alreadyExists) {
                        collisions.add(new Collision(gameObject, innerObject));
                    }
                }
            }
        }
        return collisions;
    }

    void onEnter(Player player) {
        gameObjects.add(player);
        this.player = player;
        reDraw();
    }

    Player onExit() {
        gameObjects.remove(player);
        Player temp = this.player;
        this.player = null;
        return temp;
    }

}
