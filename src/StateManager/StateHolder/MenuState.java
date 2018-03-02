package StateManager.StateHolder;

import GameObject.Graphic;
import StateManager.States;
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
        Graphic.printString(terminal, "Welcome to the coolest game in the world", 15, 15);
        Graphic.printString(terminal, "Press 'space' to start", 15, 18);
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
