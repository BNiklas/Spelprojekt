package StateManager;

import GameObject.Graphic;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class MenuState extends State {
    @Override
    public void onInit() {

    }

    @Override
    public void onInput(Key key) {
        if (key.getCharacter() == ' ') {
            exitInstructions = new StateInstruction(States.ADVENTURE_STATE);
            hasExitInstructions = true;
        }
    }

    @Override
    public void onLoop() {

    }

    @Override
    public void onDraw(Terminal terminal) {
        Graphic.printString(terminal, "Menu", 15, 15);
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
