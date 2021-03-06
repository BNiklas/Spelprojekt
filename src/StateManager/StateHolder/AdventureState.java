package StateManager.StateHolder;

import GameObject.*;
import GameObject.Characters.Player;
import Room.*;
import StateManager.*;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;
import Item.*;

public class AdventureState extends State {
    private static final int TEXT_X = 72;
    private RoomManager rooms;
    private Player player;

    public AdventureState() {
        super();
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
        } else if (key.getCharacter() == ' ') {
            exitInstructions = new StateInstruction(States.MENU_STATE);
            hasExitInstructions = true;
        }
    }

    private void printAdventureText(Terminal terminal) {
        Graphic.printString(terminal, "Health: " + player.getHealth(), 75, 5, Terminal.Color.GREEN);
        Graphic.printHealthbar(terminal, TEXT_X, 6, player.getHealth());
        Graphic.printString(terminal, "Inventory: ", TEXT_X, 10, Terminal.Color.GREEN);
        int position = 11;
        for (Item item : player.getInventory()) {
            Graphic.printString(terminal, item.getName() + ", Value: " + item.getValue(), TEXT_X, position);
            position++;
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
        printAdventureText(terminal);
        rooms.onDraw(terminal);
    }

    @Override
    public void enter() {
        super.enter();
        rooms.reDraw();
    }
}
