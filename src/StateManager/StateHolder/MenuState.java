package StateManager.StateHolder;

import GameObject.Graphic;
import StateManager.States;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class MenuState extends State {
    private static final int TEXT_X_START = 10;
    private static final int TEXT_Y_START = 10;

    @Override
    public void onInput(Key key) {
        if (key.getCharacter() == ' ') {
            exitInstructions = new StateInstruction(States.ADVENTURE_STATE);
            hasExitInstructions = true;
        }
    }

    @Override
    public void onDraw(Terminal terminal) {
        Graphic.printString(terminal, "Welcome to the coolest game in the world", TEXT_X_START, TEXT_Y_START);
        Graphic.printString(terminal, "Press 'space' to start", TEXT_X_START, TEXT_Y_START + 2);
    }
}
