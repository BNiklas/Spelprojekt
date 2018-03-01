package GameObject;

import Room.*;

public class Door extends GameObject {
    private Room room;
    private boolean hasCustomRoom;

    public Door(int x, int y, char look, Room room) {
        super(x, y, look, true);
        this.room = room;
    }

    public void setRoom(Room customRoom) {
        room = customRoom;
        hasCustomRoom = true;
    }

    public boolean HasCustomRoom() {
        return hasCustomRoom;
    }

    public Room getRoom() {
        return room;
    }
}