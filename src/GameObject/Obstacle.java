package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class Obstacle extends GameObject{
    public Obstacle(int x, int y, char look, boolean traversable) {
        super(x, y, look, traversable);
    }

    public Obstacle(int x, int y, char look, Terminal.Color color, boolean traversable) {
        super(x, y, look, color, traversable);
    }
}
