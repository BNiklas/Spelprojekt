package Room;

import GameObject.Characters.Monster;
import GameObject.Helper;
import GameObject.Obstacles.*;
import Item.Items.Valuable;
import Item.Items.Weapon;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContentGenerator {
    public static List<Wall> getWalls(){
        List<Wall> walls = new ArrayList<>();
        for(int x = 0; x <= Room.getScreenWidth(); x++){
            walls.add(new Wall(x, Room.getScreenHeight() - 1));
            walls.add(new Wall(x, 0));
        }
        for(int y = 1; y < Room.getScreenHeight() - 1; y++){
            walls.add(new Wall(Room.getScreenWidth(), y));
            walls.add(new Wall(0, y));
        }
        return walls;
    }
    public static List<Valuable> getRandomValuables(int bound) {
        ArrayList<Valuable> valuables = new ArrayList<>();
        Random rand = new Random();
        int padding = 3;

        for (int i = rand.nextInt(bound); i < bound; i++) {
            valuables.add(new Valuable(Helper.getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    Helper.getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '$', Terminal.Color.YELLOW,
                    rand.nextInt(50), Valuable.getRandomValuableName()));

        }
        return valuables;
    }
    public static List<Weapon> getRandomWeapons(int bound) {
        ArrayList<Weapon> valuables = new ArrayList<>();
        Random rand = new Random();
        int padding = 3;

        for (int i = rand.nextInt(bound); i < bound; i++) {
            valuables.add(new Weapon(Helper.getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    Helper.getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '\u2020',
                    rand.nextInt(30), "Sword", rand.nextInt(9) + 1));
        }
        return valuables;
    }
    public static List<Monster> getRandomAmountOfMonsters(int bound){
        ArrayList<Monster> monsters = new ArrayList<>();
        int padding = 10;
        Random rand = new Random();
        for(int i = rand.nextInt(bound); i < bound; i++){
            monsters.add(new Monster(Helper.getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    Helper.getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '\u046d'));
        }
        return monsters;
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
    public static List<Lake> getLake(){
        ArrayList<Lake> lakes = new ArrayList<>();

        int startX = Helper.getRandomNumberInRange(1, Room.getScreenWidth()-2);
        int startY = Helper.getRandomNumberInRange(1, Room.getScreenHeight()-2);
        for (int x = startX; x<startX+2; x++){
            for (int y = startY; y<startY+2; y++){
                lakes.add(new Lake(x, y));
            }
        }
        return lakes;
    }
}
