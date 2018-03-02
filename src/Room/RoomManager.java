package Room;

import GameObject.Door;
import GameObject.GameObject;
import GameObject.Characters.Monster;
import GameObject.Characters.Player;
import StateManager.*;
import StateManager.StateHolder.StateInstruction;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;


public class RoomManager {

    private Room currentRoom;
    private boolean needsClean = false;

    public StateInstruction instructionsToRelay = null;

    public RoomManager(Player player) {
        currentRoom = new Room();
        currentRoom.wantsBackPortal = false;
        currentRoom.onEnter(player);
    }

    public void onLoop() {
        currentRoom.onLoop();
        checkCollisions();
    }

    private void checkCollisions() {
        List<Collision> collisions = currentRoom.checkCollisions();

        for (Collision collision : collisions) {
            collision.alertObjects();

            GameObject collidedObjectOne = collision.getObject1();
            GameObject collidedObjectTwo = collision.getObject2();

            // check if player collided with door or monster and then handle it
            if (collidedObjectOne instanceof Player && collidedObjectTwo instanceof Door) {
                swapRoom(((Door) collidedObjectTwo).getRoom());
            } else if (collidedObjectOne instanceof Door && collidedObjectTwo instanceof Player) {
                swapRoom(((Door) collidedObjectOne).getRoom());
            } else if (collidedObjectOne instanceof Player && collidedObjectTwo instanceof Monster) {
                instructionsToRelay = new StateInstruction(States.COMBAT_STATE, new GameObject[] {collidedObjectOne, collidedObjectTwo});
            } else if (collidedObjectOne instanceof Monster && collidedObjectTwo instanceof Player) {
                instructionsToRelay = new StateInstruction(States.COMBAT_STATE, new GameObject[] {collidedObjectTwo, collidedObjectOne});
            }
        }
    }

    private void swapRoom(Room newRoom) {
        newRoom.onEnter(currentRoom.onExit());
        if (newRoom.wantsBackPortal) {
            newRoom.addBackPortal(currentRoom);
        }
        currentRoom = newRoom;
        needsClean = true;
    }

    public void onDraw(Terminal terminal) {
        if (needsClean) {
            terminal.clearScreen();
            needsClean = false;
        }
        currentRoom.onDraw(terminal);
    }

    public void reDraw() {
        currentRoom.reDraw();
    }
}
