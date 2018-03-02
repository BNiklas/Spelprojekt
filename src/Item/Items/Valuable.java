package Item.Items;

import Item.Item;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.*;

public class Valuable extends Item {
    private static final ArrayList<String> VALUABLE_NAMES = new ArrayList<String>(Arrays.asList(
            "Bronze piece", "Silver piece", "Ruby", "Diamond", "Gold piece", "Emerald", "Silver plate", "Tanzanite",
            "Lazurite", "Peridot", "Nephrite", "Malachite", "Charoite"));

    public Valuable(int x, int y, char look, Terminal.Color color, int value, String name) {
        super(x, y, look, color, value, name);
    }

    public static String getRandomValuableName() {
        Random rand = new Random();
        return VALUABLE_NAMES.get(rand.nextInt(VALUABLE_NAMES.size()));
    }


}
