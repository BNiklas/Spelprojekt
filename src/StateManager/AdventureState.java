package StateManager;

import GameObject.*;
import Room.*;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

public class AdventureState extends State {

    private RoomManager rooms;
    private Player player;

    @Override
    public void onInit() {
        player = new Player(5, 5, '\u263b');
        rooms = new RoomManager(player);
    }

    @Override
    public void onInput(Key key) {
        if (key.getKind() == Key.Kind.ArrowDown || key.getCharacter() == 's') {
            player.onMove(0, 1);
        } else if (key.getKind() == Key.Kind.ArrowUp || key.getCharacter() == 'w') {
            player.onMove(0, -1);
        } else if (key.getKind() == Key.Kind.ArrowLeft || key.getCharacter() == 'a') {
            player.onMove(-1, 0);
        } else if (key.getKind() == Key.Kind.ArrowRight || key.getCharacter() == 'd') {
            player.onMove(1, 0);
        } else  if (key.getCharacter() == ' ') {
            exitInstructions = new StateInstruction(States.MENU_STATE);
            hasExitInstructions = true;
        }
    }

    @Override
    public void onLoop() {
        rooms.onLoop();

        if (rooms.instructionsToRelay != null) {
            exitInstructions = rooms.instructionsToRelay;
            hasExitInstructions = true;
            rooms.instructionsToRelay = null;
        }
    }

    @Override
    public void onDraw(Terminal terminal) {
        rooms.onDraw(terminal);
    }

    @Override
    public void enter() {
        rooms.reDraw();
    }

    @Override
    public void exit() {

    }
}
