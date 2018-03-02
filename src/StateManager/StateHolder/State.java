package StateManager.StateHolder;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;


abstract public class State {
    boolean hasExitInstructions = false;
    StateInstruction exitInstructions = null;

    public void onInput(Key key) {
    }

    public void onLoop() {
    }

    abstract public void onDraw(Terminal terminal);

    public void enter() {
    }

    public boolean hasExitInstructions() {
        return hasExitInstructions;
    }

    public StateInstruction getExitInstructions() {
        hasExitInstructions = false;
        StateInstruction temp = exitInstructions;
        exitInstructions = null;
        return temp;
    }
}
