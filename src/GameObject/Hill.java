package GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hill extends Obstacle{
    public Hill(int x, int y) {
        super(x, y, '\u0394', false);
    }


   /* public static List<Hill> getHills()





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
        return monsters;*/
}
