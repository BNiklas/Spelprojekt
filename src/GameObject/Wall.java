package GameObject;

import Room.Room;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Obstacle{
    public Wall(int x, int y) {
        super(x, y, '\u2588', Terminal.Color.CYAN, false);
        this.needsToDraw();
    }

    public static List<Wall> getWalls(){
        List<Wall> walls = new ArrayList<>();
        for(int x = 0; x <= Room.getScreenWidth(); x++){
            walls.add(new Wall(x, Room.getScreenHeight() - 1));
            walls.add(new Wall(x, 0));
        }
        for(int y = 0; y < Room.getScreenHeight(); y++){
            walls.add(new Wall(Room.getScreenWidth(), y));
            walls.add(new Wall(0, y));
        }
        return walls;
    }
}
