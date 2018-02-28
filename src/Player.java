public class Player extends Character {
    public Player(int x, int y, char look) {
        super(x, y, look);
    }

    public void onMove(int changeX, int changeY) {
        move(changeX, changeY);
    }
}
