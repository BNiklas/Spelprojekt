package StateManager.StateHolder;

import GameObject.Graphic;
import GameObject.Characters.Player;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameoverState extends State {
    private Player player;

    public GameoverState(Player player) {
        super();
        this.player = player;
    }

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
        Graphic.printString(terminal, "Your score is: " + player.getInventoryValue(), 15, 17);
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
