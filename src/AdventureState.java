import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class AdventureState {

    List<Room> rooms = new ArrayList<>();

    public void onInit() {
        rooms.add(new Room());
        for (Room room : rooms) {
            room.onInit();
        }
    }

    public void onDraw(Terminal terminal) {
        for (Room room : rooms) {
            room.onDraw(terminal);
        }
    }
}
