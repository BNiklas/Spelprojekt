package Item.Items;

import Item.Item;
import Room.*;
import com.googlecode.lanterna.terminal.Terminal;
import GameObject.Helper;

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
            valuables.add(new Valuable(Helper.getRandomNumberInRange(padding, (Room.getScreenWidth() - padding)),
                    Helper.getRandomNumberInRange(padding, (Room.getScreenHeight() - padding)), '$', Terminal.Color.YELLOW,
                    rand.nextInt(50), getRandomValuableName()));

        }
        return valuables;
    }
    private static String getRandomValuableName() {
        Random rand = new Random();
        return VALUABLE_NAMES.get(rand.nextInt(VALUABLE_NAMES.size()));
    }


}
