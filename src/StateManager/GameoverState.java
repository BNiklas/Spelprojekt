package StateManager;

import GameObject.Graphic;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameoverState extends State {
    @Override
    public void onInit() {

    }

    @Override
    public void onInput(Key key) {
        
    }

    @Override
    public void onLoop() {

    }

    @Override
    public void onDraw(Terminal terminal) {
        Graphic.printString(terminal, "Game over", 15, 15);
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
