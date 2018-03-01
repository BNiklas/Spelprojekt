package Item;

import Room.*;

import java.util.*;

import static java.util.Map.entry;

public class Valuable extends Item {
    private static final Map<String, Integer> values = Map.ofEntries(
            entry("Bronze piece", 1),
            entry("Silver piece", 5),
            entry("Ruby", 15),
            entry("Diamond", 50),
            entry("Gold piece", 10),
            entry("Emerald", 25),
            entry("Silver plate", 15),
            entry("Tanzanite", 30),
            entry("Lazurite", 35),
            entry("Peridot", 20),
            entry("Nephrite", 40),
            entry("Malachite", 45),
            entry("Charoite", 17)
    );

    private Valuable(int x, int y, char look, int value, String name) {
        super(x, y, look, value, name);
    }

    public static List<Valuable> getRandomValuables(int bound) {
        ArrayList<Valuable> valuables = new ArrayList<>();
        Random rand = new Random();
        int padding = 3;

        for (int i = rand.nextInt(bound); i < bound; i++) {
            valuables.add(new Valuable(getRandomNumberInRange(padding, (Room.getScreenwidth() - padding)),
                    getRandomNumberInRange(padding, (Room.getScreenheight() - padding)), '$', 0 , "default"));

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
    private static Valuable getRandomValuable(){
        return null;
    }


}
