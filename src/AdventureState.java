import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

import java.util.ArrayList;
import java.util.List;

public class AdventureState extends State {

    private List<Room> rooms = new ArrayList<>();
    private Player player;

    @Override
    public void onInit() {
        player = new Player(15, 15, 'P');
        rooms.add(new Room(player));
        for (Room room : rooms) {
            room.onInit();
        }
    }

    @Override
    public void onInput(Key key) {

    }

    @Override
    public void onLoop() {
        for (Room room : rooms) {
            room.onLoop();
        }
    }

    @Override
    public void onDraw(Terminal terminal) {
        for (Room room : rooms) {
            room.onDraw(terminal);
        }
    }
}
