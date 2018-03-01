package Item;

import Room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            valuables.add(new Weapon(getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '\u2020',
                    rand.nextInt(30), "Weapon", rand.nextInt(10)));
        }
        return valuables;
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random rand = new Random();
        int randomNum = Integer.MIN_VALUE;
        while (randomNum < min) {
            randomNum = rand.nextInt(max);
        }
        return randomNum;
    }

}
