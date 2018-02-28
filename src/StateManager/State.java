package StateManager;

import Room.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;


abstract public class State {
    private List<Room> rooms;

    abstract public void onInit();
    abstract public void onInput(Key key);
    abstract public void onLoop();
    abstract public void onDraw(Terminal terminal);
    abstract public void enter();
    abstract public void exit();
}
