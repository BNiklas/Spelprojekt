package Room;

import GameObject.*;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<GameObject> gameObjects;

    public Room(Player player) {
        this.gameObjects = new ArrayList<>();
        gameObjects.add(player);
    }

    public void onInit() {
        gameObjects.add(new Monster(10, 10, 'M'));
    }

    public void onLoop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.onLoop((Player)gameObjects.get(0)); // TODO: 2018-02-28 Fix better
        }
    }

    public void onDraw(Terminal terminal) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onDraw(terminal);
        }
    }
}
