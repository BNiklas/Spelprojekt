public class GameObject {
    private int x;
    private int y;
    private char look;


    protected GameObject(int x, int y, char look) {
        this.x = x;
        this.y = y;
        this.look = look;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLook() {
        return look;
    }
}
