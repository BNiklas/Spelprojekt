package Room;

import GameObject.Player;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;
    private Room currentRoom;
    private Player player;

    public RoomManager(Player player) {
        this.player = player;
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
        }
    }

    public void onDraw(Terminal terminal) {
        currentRoom.onDraw(terminal);
    }

    public void reDraw() {
        currentRoom.reDraw();
    }
}
