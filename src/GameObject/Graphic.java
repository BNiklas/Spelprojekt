package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class Graphic {
    private char graphic;

    Graphic(char graphic) {
        this.graphic = graphic;
    }

    public void draw(Terminal terminal, int x, int y, int xOld, int yOld) {
        erase(terminal, xOld, yOld);
        terminal.moveCursor(x, y);
        terminal.putCharacter(graphic);
    }

    private void erase(Terminal terminal, int x, int y) {
        terminal.moveCursor(x, y);
        terminal.putCharacter(' ');
    }

    public static void printString(Terminal terminal, String input, int x, int y) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(chars[i]);
        }

    }

    public static void printHealthbar(Terminal terminal, int x, int y, int health) {

        char charToPrint = '\u2588';
        if (health < 10 && health > 0) {
            health = 10;
        }

        for (int i = 0; i < health / 10; i++) {
            terminal.applyForegroundColor(Terminal.Color.GREEN);
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(charToPrint);
        }
        for (int i = health / 10; i < 10; i++) {
            terminal.applyForegroundColor(Terminal.Color.RED);
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(charToPrint);
        }
    }
}
