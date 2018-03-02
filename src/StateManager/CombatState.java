package StateManager;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import GameObject.*;
import jdk.nashorn.api.tree.Tree;

import java.lang.Character;
import java.util.Random;

public class CombatState extends State {
    Player player;
    Monster enemy;
    int playerAttack = 5;
    int enemyAttack = -1;
    boolean clear = false;

    final int[][] dmgArray = {{0, 1, 1, 1, 1, 1, 1, 2, 2, 2},
                              {1, 0, 1, 1, 2, 2, 3, 3, 4, 5},
                              {1, 1, 0, 1, 1, 2, 2, 3, 3, 4},
                              {1, 1, 1, 0, 1, 1, 2, 2, 3, 3},
                              {1, 2, 1, 1, 0, 1, 1, 2, 2, 3},
                              {1, 2, 2, 1, 1, 0, 1, 1, 2, 2},
                              {1, 3, 2, 2, 1, 1, 0, 1, 1, 2},
                              {2, 3, 3, 2, 2, 1, 1, 0, 1, 1},
                              {2, 4, 3, 3, 2, 2, 1, 1, 0, 1},
                              {2, 5, 4, 3, 3, 2, 2, 1, 1, 0}};

    public void setFighters(GameObject player, GameObject monster) {
        this.player = (Player) player;
        this.enemy = (Monster) monster;
    }

    @Override
    public void onInit() {
        // for testing
        this.player = new Player(1, 1, 'a');
        this.enemy = new Monster(1, 1, 'a');
    }

    @Override
    public void onInput(Key key) {
        switch (key.getKind()) {
            case ArrowUp:
                if (playerAttack<player.getStamina())
                    playerAttack++;
                break;
            case ArrowDown:
                if(playerAttack>0)
                    playerAttack--;
                break;
            case Enter:
                Random rand = new Random();
                enemyAttack=rand.nextInt(10);
                updateHealth();
                updateStamina();
                break;
        }
    }


    @Override
    public void onLoop() {

    }

    @Override
    public void onDraw(Terminal terminal) {
        if(enemy.getHealth()>0 && player.getHealth()>0) {
            Graphic.printString(terminal, "You have encountered a " + enemy.getType(), 1, 1);
            Graphic.printString(terminal, "-Stamina: " + enemy.getStamina(), 3, 2);
            Graphic.printString(terminal, "-Health: " + enemy.getHealth(), 3, 3);

            Graphic.printString(terminal, "How hard will you hit?: " + playerAttack, 32, 13);
            if(enemyAttack!=-1) {
                Graphic.printString(terminal, "Enemy hits for... " + enemyAttack, 32, 14);
                Graphic.printString(terminal, "Enemy hits for... " + enemyAttack, 32, 14);
            }

            Graphic.printString(terminal, "Player status ", 40, 25);
            Graphic.printString(terminal, "-Stamina: " + player.getStamina(), 43, 26);
            Graphic.printString(terminal, "-Health: " + player.getHealth(), 43, 27);
        }
        else if(!clear) {
            terminal.clearScreen();
            clear=true;
        }
        if (enemy.getHealth()<1) {
            Graphic.printString(terminal, "You killed the " + enemy.getType(), 32, 13);
            exitInstructions = new StateInstruction(States.ADVENTURE_STATE);
            hasExitInstructions = true;
        }
        else if(player.getHealth()<1) {
            Graphic.printString(terminal, "The " + enemy.getType() + " killed you!", 32, 13);
            exitInstructions = new StateInstruction(States.GAMEOVER_STATE);
            hasExitInstructions = true;
        }
    }
    private void updateHealth() {
        if(playerAttack > enemyAttack)
            enemy.setHealth(enemy.getHealth()-Math.abs(dmgArray[playerAttack][enemyAttack]));
        else if(enemyAttack > playerAttack)
            player.setHealth(player.getHealth()-Math.abs(dmgArray[enemyAttack][playerAttack]));
    }

    private void updateStamina() {
        if(playerAttack==0 && !(player.getStamina()+3>9))
            player.setStamina(player.getStamina()+3);
        else if(playerAttack==0 && !(player.getStamina()+1>9))
            player.setStamina(player.getStamina()+(9-player.getStamina()));
        else
            player.setStamina(player.getStamina()-(int)Math.ceil((double)playerAttack/2));
        playerAttack=player.getStamina();
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }
}
