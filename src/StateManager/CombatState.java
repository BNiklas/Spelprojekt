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
            printCombatText(terminal);
        }
        else if(!clear) {
            terminal.clearScreen();
            clear=true;
        }
        if (enemy.getHealth()<1) {
            enemy.kill();
            Graphic.printString(terminal, "You killed the " + enemy.getType(), 32, 13);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exitInstructions = new StateInstruction(States.ADVENTURE_STATE);
            hasExitInstructions = true;
        }
        else if(player.getHealth()<1) {
            player.kill();
            Graphic.printString(terminal, "The " + enemy.getType() + " killed you!", 32, 13);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    private void printCombatText(Terminal terminal) {
        //Tutorial
        Graphic.printString(terminal, "HOW TO PLAY:", 72, 1);
        Graphic.printString(terminal, "The highest attackvalue", 72, 3);
        Graphic.printString(terminal, "wins the round and deals", 72, 4);
        Graphic.printString(terminal, "damage to their opponent.", 72, 5);
        Graphic.printString(terminal, "It is over once you or the", 72, 7);
        Graphic.printString(terminal, "enemys health reaches zero", 72, 8);
        Graphic.printString(terminal, "-Chose attack value", 72, 12);
        Graphic.printString(terminal, "-Press Enter to lock in", 72, 13);
        Graphic.printString(terminal, "To regain stamina, chose", 72, 16);
        Graphic.printString(terminal, "\"Defend\", you can't deal", 72, 17);
        Graphic.printString(terminal, "damage but will take ", 72, 18);
        Graphic.printString(terminal, "minimum damage yourself.", 72, 19);

        //Extra wall
        terminal.applyForegroundColor(Terminal.Color.CYAN);
        for(int i=70; i<100; i++){
            terminal.moveCursor(i,23);
            terminal.putCharacter('\u2588');
        }
        terminal.applyForegroundColor(Terminal.Color.WHITE);

        //Enemy stats
        Graphic.printString(terminal, "You have encountered a " + enemy.getType(), 4, 2);
        Graphic.printString(terminal, "-Stamina: " + enemy.getStamina(), 6, 3);
        Graphic.printString(terminal, "-Health: " + enemy.getHealth()+" ", 6, 4);
        //Combat texts
        if(playerAttack==0)
            Graphic.printString(terminal, "You will Defend this turn!", 27, 13);
        else
            Graphic.printString(terminal, "How hard will you hit?:  " + playerAttack, 27, 13);
        if(enemyAttack!=-1) {
            Graphic.printString(terminal, "Enemy hits for... " + enemyAttack, 27, 14);
            Graphic.printString(terminal, "Enemy hits for... " + enemyAttack, 27, 14);
        }
        //Player stats
        Graphic.printString(terminal, "Player status ", 47, 25);
        Graphic.printString(terminal, "-Stamina: " + player.getStamina(), 50, 26);
        Graphic.printString(terminal, "-Health: " + player.getHealth()+" ", 50, 27);
        Graphic.printString(terminal, "Your weapon:(weapon)", 75, 26);
        Graphic.printString(terminal, "    +(dmg) to damage", 75, 27);
    }
}
