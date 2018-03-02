package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class Graphic {
    private char graphic;
    private Terminal.Color color;

    public Graphic(char graphic) {
        this.graphic = graphic;
        this.color = Terminal.Color.WHITE;
    }
    public Graphic(char graphic, Terminal.Color color){
        this.graphic = graphic;
        this.color = color;
    }

    public void draw(Terminal terminal, int x, int y, int xOld, int yOld) {
        erase(terminal, xOld, yOld);
        terminal.moveCursor(x, y);
        terminal.applyForegroundColor(color);
        terminal.putCharacter(graphic);
    }

    public static void erase(Terminal terminal, int x, int y) {
        terminal.moveCursor(x, y);
        terminal.putCharacter(' ');
    }

    public static void printString(Terminal terminal, String input, int x, int y) {
        printString(terminal, input, x, y, Terminal.Color.WHITE);
    }
    public static void printString(Terminal terminal, String input, int x, int y, Terminal.Color color) {
        char[] chars = input.toCharArray();
        terminal.applyForegroundColor(color);
        for (int i = 0; i < chars.length; i++) {
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(chars[i]);
        }
    }

    public static void printHealthbar(Terminal terminal, int x, int y, int health) {

        char charToPrint = '\u2588';
//        if (health < 10 && health > 0) {
//            health = 10;
//        }

        for (int i = 0; i < health; i++) {
            terminal.applyForegroundColor(Terminal.Color.GREEN);
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(charToPrint);
        }
        for (int i = 15; i < health; i--) {
            terminal.applyForegroundColor(Terminal.Color.RED);
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(charToPrint);
        }
    }
}
