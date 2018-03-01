package GameObject;

public class Wall extends Obstacle{
    public Wall(int x, int y) {
        super(x, y, '#', false);
        this.needsToDraw();
    }
}
