package GameObject.Obstacles;

import com.googlecode.lanterna.terminal.Terminal;


public class Hill extends Obstacle {
    public Hill(int x, int y) {
        super(x, y, '\u0394', Terminal.Color.RED, false);
    }

}
