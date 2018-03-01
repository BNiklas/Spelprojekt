package GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Chaser {
    String type;
    String[] types={"Skeleton","Goblin"};
    public Monster(int x, int y, char look) {
        super(x, y, look);
        Random rand = new Random();
        this.type=types[rand.nextInt(2)];
        setSpeed(1);
    }

    @Override
    public void onLoop() {
        if (lookFor(target)) {
            chase(target);
        }
    }

    private boolean lookFor(GameObject object) {
        int searchRange = 5;
        if (Math.abs(this.getX() - object.getX()) < searchRange && Math.abs(this.getY() - object.getY()) < searchRange) {
            return true;
        }
        return false;
    }

    private void chase(GameObject object) {
        if (this.getX() < object.getX()) {
            move(this.getSpeed(), 0);
        } else if (this.getX() > object.getX()) {
            move(-this.getSpeed(), 0);
        } else if (this.getY() < object.getY()) {
            move(0, this.getSpeed());
        } else if(this.getY() > object.getY()){
            move(0, -this.getSpeed());
        }
    }
    public static List<Monster> getRandomAmountOfMonsters(int bound){
        ArrayList<Monster> monsters = new ArrayList<>();
        int padding = 10;
        int screenWidth = 70;
        int screenHeight = 30;
        Random rand = new Random();
        for(int i = rand.nextInt(bound); i < bound; i++){
            monsters.add(new Monster(getRandomNumberInRange(padding, (screenWidth - padding)),
                    getRandomNumberInRange(padding, (screenHeight - padding)), 'M'));
        }
        return monsters;
    }
    private static int getRandomNumberInRange(int min, int max){
        Random rand = new Random();
        int randomNum = Integer.MIN_VALUE;
        while(randomNum < min){
            randomNum = rand.nextInt(max);
        }
        return randomNum;
    }

    public String getType(){
        return type;
    }

}
