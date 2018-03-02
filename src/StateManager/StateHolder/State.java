package StateManager.StateHolder;

import Room.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;


abstract public class State {
    protected boolean hasExitInstructions = false;
    protected StateInstruction exitInstructions = null;

    private List<Room> rooms;

    abstract public void onInit();
    abstract public void onInput(Key key);
    abstract public void onLoop();
    abstract public void onDraw(Terminal terminal);
    abstract public void enter();
    abstract public void exit();

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
