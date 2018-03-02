package GameObject.Obstacles;

import GameObject.*;
import Room.Room;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Hill extends Obstacle {
    public Hill(int x, int y) {
        super(x, y, '\u0394', Terminal.Color.RED, false);
    }


    public static List<Hill> getHills() {
        ArrayList<Hill> hills = new ArrayList<>();
        int startX = Helper.getRandomNumberInRange(1, Room.getScreenWidth() - 2);
        int startY = Helper.getRandomNumberInRange(1, Room.getScreenHeight() - 2);
        for (int x = startX; x < startX + 2; x++) {
            for (int y = startY; y < startY + 2; y++) {
                hills.add(new Hill(x, y));
            }
        }
        return hills;

    }

}
