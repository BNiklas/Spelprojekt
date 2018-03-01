package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class GameObject {
    private int x;
    private int y;
    private int xOld;
    private int yOld;
    private Graphic graphic;
    private boolean needsDraw = false;
    private boolean traversable;

    public GameObject(int x, int y, char look, boolean traversable) {
        this.x = xOld = x;
        this.y = yOld = y;
        this.graphic = new Graphic(look);
        this.traversable = traversable;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void onDraw(Terminal terminal) {
        if(needsDraw) {
            graphic.draw(terminal, this.x, this.y, this.xOld, this.yOld);
            needsDraw = false;
        }
    }

    public void onCollide(GameObject object) {
        // TODO handle collide
    }

    protected boolean isTraversable() {
        return traversable;
    }

    protected void move(int changeX, int changeY) {
        needsDraw = true;
        xOld = this.x;
        yOld = this.y;
        this.x += changeX;
        this.y += changeY;
    }

    public void needsToDraw() {
        needsDraw = true;
    }
}
