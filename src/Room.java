import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    List<GameObject> gameObjects = new ArrayList<>();
    Player player = new Player(15, 15, 'P');

    public void onInit() {
        gameObjects.add(player);
        gameObjects.add(new Monster(10, 10, 'M'));
    }

    public void onDraw(Terminal terminal) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onDraw(terminal);
        }
    }
}
