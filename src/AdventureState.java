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
        if (key.getKind() == Key.Kind.ArrowDown) {
            player.onMove(0, 1);
        } else if (key.getKind() == Key.Kind.ArrowUp) {
            player.onMove(0, -1);
        } else if (key.getKind() == Key.Kind.ArrowLeft) {
            player.onMove(-1, 0);
        } else if (key.getKind() == Key.Kind.ArrowRight) {
            player.onMove(1, 0);
        } else  if (key.getCharacter() == ' ') {
            System.out.println("interacting");
        }
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

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
