package Room;

import GameObject.Door;
import GameObject.Player;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;
    private Room currentRoom;

    public RoomManager(Player player) {
        rooms  = new ArrayList<>();
        rooms.add(new Room(player));
        currentRoom = rooms.get(0);
    }

    public void onInit() {
        for (Room room : rooms) {
            room.onInit();
        }
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
                currentRoom = ((Door) collision.getObject2()).getRoom();
            } else if (collision.getObject1() instanceof Door && collision.getObject2() instanceof Player) {
                currentRoom = ((Door) collision.getObject1()).getRoom();
            }
        }
    }

    public void onDraw(Terminal terminal) {
        currentRoom.onDraw(terminal);
    }

    public void reDraw() {
        currentRoom.reDraw();
    }
}
