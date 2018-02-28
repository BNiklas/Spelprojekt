import com.googlecode.lanterna.terminal.Terminal;

public class GameObject {
    private int x;
    private int y;
    private Graphic graphic;


    protected GameObject(int x, int y, char look) {
        this.x = x;
        this.y = y;
        this.graphic = new Graphic(look);
    }

    public void onLoop() {

    }

    public void onDraw(Terminal terminal) {
        graphic.draw(terminal, this.x, this.y);
    }
}
