package GameObject.Obstacles;

import com.googlecode.lanterna.terminal.Terminal;

public class Lake extends Obstacle {
    public Lake(int x, int y){
        super(x, y, '\u007e', Terminal.Color.BLUE, false);
    }

}
