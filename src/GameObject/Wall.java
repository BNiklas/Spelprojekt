package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class Wall extends Obstacle{
    public Wall(int x, int y) {
        super(x, y, '\u2588', Terminal.Color.CYAN, false);
        this.needsToDraw();
    }
}
