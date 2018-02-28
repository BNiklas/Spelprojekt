import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<GameObject> gameObjects;

    Room(Player player) {
        this.gameObjects = new ArrayList<>();
        gameObjects.add(player);
    }

    public void onInit() {
        gameObjects.add(new Monster(10, 10, 'M'));
    }

    public void onLoop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.onLoop();
        }
    }

    public void onDraw(Terminal terminal) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onDraw(terminal);
        }
    }
}
