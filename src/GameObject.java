import com.googlecode.lanterna.terminal.Terminal;

public class GameObject {
    private int x;
    private int y;
    private int xOld;
    private int yOld;
    private Graphic graphic;


    protected GameObject(int x, int y, char look) {
        this.x = xOld = x;
        this.y = yOld = y;
        this.graphic = new Graphic(look);
    }

    public void onLoop(Player player) {

    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    public void onDraw(Terminal terminal) {
        graphic.draw(terminal, this.x, this.y, this.xOld, this.yOld);
    }

    protected void move(int changeX, int changeY) {
        xOld = this.x;
        yOld = this.y;
        this.x += changeX;
        this.y += changeY;
    }
}
