package GameObject;

import com.googlecode.lanterna.terminal.Terminal;

public class GameObject {
    private int x;
    private int y;
    protected int xOld;
    protected int yOld;
    private Graphic graphic;
    private boolean needsDraw = false;
    private boolean traversable;
    private boolean justMoved;

    public GameObject(int x, int y, char look, boolean traversable) {
        this.x = xOld = x;
        this.y = yOld = y;
        this.graphic = new Graphic(look);
        this.traversable = traversable;
    }
    public GameObject(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void onLoop() {
        justMoved = false;
    }

    public void onDraw(Terminal terminal) {
        if(needsDraw) {
            graphic.draw(terminal, this.x, this.y, this.xOld, this.yOld);
            needsDraw = false;
        }
    }

    public void onCollide(GameObject object) {
        if (!object.isTraversable()) {
            if (justMoved) {
                x = xOld;
                y = yOld;
                needsDraw = true;
            }
        }
    }

    protected boolean isTraversable() {
        return traversable;
    }

    protected void move(int changeX, int changeY) {
        xOld = this.x;
        yOld = this.y;
        this.x += changeX;
        this.y += changeY;
        needsDraw = true;
        justMoved = true;
    }

    public void needsToDraw() {
        needsDraw = true;
    }
}
