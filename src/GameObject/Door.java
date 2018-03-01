package GameObject;

import Room.*;
import com.googlecode.lanterna.terminal.Terminal;

public class Door extends GameObject {
    private Room room;

    public Door(int x, int y, Terminal.Color color, Room room) {
        super(x, y, '\u0489', color, true);
        this.room = room;
    }

    public Door(int x, int y, Room room) {
        this(x, y, Terminal.Color.RED, room);
    }


    @Override
    public void onLoop() {
        super.onLoop();
        needsToDraw();
    }

    public Door(int x, int y) {
        this(x, y, null);
    }

    public Room getRoom() {
        if (room == null) {
            return new Room();
        }
        return room;
    }
}