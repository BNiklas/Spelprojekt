import com.googlecode.lanterna.terminal.Terminal;

public class Graphic {
    private char graphic;

    Graphic(char graphic) {
        this.graphic = graphic;
    }

    public void draw(Terminal terminal, int x, int y) {
        terminal.moveCursor(x, y);
        terminal.putCharacter(graphic);
    }
}
