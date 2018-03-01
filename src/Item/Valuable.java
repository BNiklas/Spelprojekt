package Item;

import Room.*;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.*;


public class Valuable extends Item {
    private static final ArrayList<String> VALUABLE_NAMES = new ArrayList<String>(Arrays.asList(
            "Bronze piece", "Silver piece", "Ruby", "Diamond", "Gold piece", "Emerald", "Silver plate", "Tanzanite",
            "Lazurite", "Peridot", "Nephrite", "Malachite", "Charoite"));

    private Valuable(int x, int y, char look, int value, String name) {
        super(x, y, look, value, name);
    }

    public Valuable(int x, int y, char look, Terminal.Color color, int value, String name) {
        super(x, y, look, color, value, name);
    }

    public static List<Valuable> getRandomValuables(int bound) {
        ArrayList<Valuable> valuables = new ArrayList<>();
        Random rand = new Random();
        int padding = 3;

        for (int i = rand.nextInt(bound); i < bound; i++) {
            valuables.add(new Valuable(getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '$', Terminal.Color.YELLOW,
                    rand.nextInt(50), getRandomValuableName()));

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

    private static String getRandomValuableName() {
        Random rand = new Random();
        return VALUABLE_NAMES.get(rand.nextInt(VALUABLE_NAMES.size()));
    }


}
