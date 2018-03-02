package StateManager.StateHolder;

import GameObject.Graphic;
import GameObject.Characters.Player;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameoverState extends State {
    private Player player;

    private static final int TEXT_X_START = 10;
    private static final int TEXT_Y_START = 10;

    public GameoverState(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void onDraw(Terminal terminal) {
        Graphic.printString(terminal, "Game over", TEXT_X_START, TEXT_Y_START);
        Graphic.printString(terminal, "Your score is: " + player.getInventoryValue(), TEXT_X_START, TEXT_Y_START + 2);
    }
}
