package Room;

import GameObject.Door;
import GameObject.Player;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;
    private Room currentRoom;
    private boolean needsClean = false;

    public RoomManager(Player player) {
        rooms  = new ArrayList<>();
        currentRoom = new Room();
        currentRoom.wantsBackPortal = false;
        currentRoom.onEnter(player);
        rooms.add(currentRoom);
    }

    public void onLoop() {
        currentRoom.onLoop();
        checkCollisions();
    }

    private void checkCollisions() {
        List<Collision> collisions = currentRoom.checkCollisions();
        for (Collision collision : collisions) {
            collision.alert();
            if (collision.getObject1() instanceof Player && collision.getObject2() instanceof Door) {
                swapRoom(((Door) collision.getObject2()).getRoom());
            } else if (collision.getObject1() instanceof Door && collision.getObject2() instanceof Player) {
                swapRoom(((Door) collision.getObject1()).getRoom());
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
