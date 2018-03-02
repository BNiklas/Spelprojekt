package GameObject.Obstacles;

import Room.Room;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static GameObject.Helper.getRandomNumberInRange;

public class Lake extends Obstacle {
    public Lake(int x, int y){
        super(x, y, '\u007e', Terminal.Color.BLUE, false);
    }

    public static List<Lake> getLake(){
        ArrayList<Lake> lakes = new ArrayList<>();

        int startX = getRandomNumberInRange(1, Room.getScreenWidth()-2);
        int startY = getRandomNumberInRange(1, Room.getScreenHeight()-2);
        for (int x = startX; x<startX+2; x++){
            for (int y = startY; y<startY+2; y++){
                lakes.add(new Lake(x, y));
            }
        }
        return lakes;
    }

}
