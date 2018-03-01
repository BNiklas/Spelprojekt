package Room;

import GameObject.*;
import Item.Valuable;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<GameObject> gameObjects;
    Player player;

    private static final int SCREENWIDTH = 70;
    private static final int SCREENHEIGHT = 30;


    public Room(Player player) {
        this.player = player;
        this.gameObjects = new ArrayList<>();
        gameObjects.add(player);
    }
    public Room(Player player, List<GameObject> gameObjects){

    }
    public static int getScreenwidth() {
        return SCREENWIDTH;
    }

    public static int getScreenheight() {
        return SCREENHEIGHT;
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
    private void addRandomItems(List<GameObject> gameObjects){
        gameObjects.addAll(Valuable.getRandomValuables(3));
    }
    private void addMonsters(List<GameObject> gameObjects){
        gameObjects.addAll(Monster.getRandomAmountOfMonsters(4));
    }
}
