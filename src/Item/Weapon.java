package Item;

import Room.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GameObject.Helper;

public class Weapon extends Item {

    private int attackValue;

    public Weapon() {
        this.attackValue = 0;
    }

    public Weapon(int value, String name, int attackValue) {
        super(value, name);
        this.attackValue = attackValue;
    }

    private Weapon(int x, int y, char look, int value, String name, int attackValue) {
        super(x, y, look, value, name);
        this.attackValue = attackValue;
    }

    public static List<Weapon> getRandomWeapons(int bound) {
        ArrayList<Weapon> valuables = new ArrayList<>();
        Random rand = new Random();
        int padding = 3;

        for (int i = rand.nextInt(bound); i < bound; i++) {
            valuables.add(new Weapon(Helper.getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    Helper.getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '\u2020',
                    rand.nextInt(30), "Weapon", rand.nextInt(10)));
        }
        return valuables;
    }
}
