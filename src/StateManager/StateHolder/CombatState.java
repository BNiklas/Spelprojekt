package StateManager.StateHolder;

import GameObject.Characters.Monster;
import GameObject.Characters.Player;
import StateManager.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import GameObject.*;

import java.util.Random;

public class CombatState extends State {
    private Player player;
    private Monster enemy;
    private int playerAttack = 5;
    private int enemyAttack = -1;
    private boolean clear = false;
    private boolean needsToPrintInstruction = true;
    private static final int TEXT_X_MIDDLE = 32;
    private static final int TEXT_X_RIGHT = 72;

    private final int[][] dmgArray = {{0, 1, 1, 1, 1, 1, 1, 2, 2, 2},
            {1, 0, 1, 1, 2, 2, 3, 3, 4, 5},
            {1, 1, 0, 1, 1, 2, 2, 3, 3, 4},
            {1, 1, 1, 0, 1, 1, 2, 2, 3, 3},
            {1, 2, 1, 1, 0, 1, 1, 2, 2, 3},
            {1, 2, 2, 1, 1, 0, 1, 1, 2, 2},
            {1, 3, 2, 2, 1, 1, 0, 1, 1, 2},
            {2, 3, 3, 2, 2, 1, 1, 0, 1, 1},
            {2, 4, 3, 3, 2, 2, 1, 1, 0, 1},
            {2, 5, 4, 3, 3, 2, 2, 1, 1, 0}};

    public CombatState(GameObject player, GameObject monster) {
        super();
        this.player = (Player) player;
        ((Player) player).setStamina(9);
        this.enemy = (Monster) monster;
    }

    @Override
    public void onInput(Key key) {
        switch (key.getKind()) {
            case ArrowUp:
                if (playerAttack < player.getStamina())
                    playerAttack++;
                break;
            case ArrowDown:
                if (playerAttack > 0)
                    playerAttack--;
                break;
            case Enter:
                Random rand = new Random();
                enemyAttack = rand.nextInt(10);
                updateHealth();
                updateStamina();
                break;
        }
    }


    @Override
    public void onDraw(Terminal terminal) {
        if (enemy.getHealth() > 0 && player.getHealth() > 0) {
            printCombatText(terminal);
        } else if (!clear) {
            terminal.clearScreen();
            clear = true;
        }
        if (enemy.getHealth() < 1) {
            enemy.kill();
            Graphic.printString(terminal, "You killed the " + enemy.getType(), TEXT_X_MIDDLE, 13);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exitInstructions = new StateInstruction(States.ADVENTURE_STATE);
            hasExitInstructions = true;
        } else if (player.getHealth() < 1) {
            player.kill();
            Graphic.printString(terminal, "The " + enemy.getType() + " killed you!", TEXT_X_MIDDLE, 13);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameObject[] temp = {player};
            exitInstructions = new StateInstruction(States.GAMEOVER_STATE, temp);
            hasExitInstructions = true;
        }
    }


    private void updateHealth() {
        if (playerAttack > enemyAttack)
            enemy.setHealth(enemy.getHealth() - (Math.abs(dmgArray[playerAttack][enemyAttack]) + player.getBestWeapon().getAttackValue()));
        else if (enemyAttack > playerAttack)
            player.setHealth(player.getHealth() - Math.abs(dmgArray[enemyAttack][playerAttack]));
    }

    private void updateStamina() {
        if (playerAttack == 0 && !(player.getStamina() + 3 > 9))
            player.setStamina(player.getStamina() + 3);
        else if (playerAttack == 0 && !(player.getStamina() + 1 > 9))
            player.setStamina(player.getStamina() + (9 - player.getStamina()));
        else
            player.setStamina(player.getStamina() - (int) Math.ceil((double) playerAttack / 2));
        playerAttack = player.getStamina();
    }

    @Override
    public void onLoop() {

    }

    private void printCombatText(Terminal terminal) {

        //Tutorial
        if (needsToPrintInstruction) {
            Graphic.printString(terminal, "HOW TO PLAY:", TEXT_X_RIGHT, 1);
            Graphic.printString(terminal, "The highest attackvalue", TEXT_X_RIGHT, 3);
            Graphic.printString(terminal, "wins the round and deals", TEXT_X_RIGHT, 4);
            Graphic.printString(terminal, "damage to their opponent.", TEXT_X_RIGHT, 5);
            Graphic.printString(terminal, "It is over once you or the", TEXT_X_RIGHT, 7);
            Graphic.printString(terminal, "enemys health reaches zero", TEXT_X_RIGHT, 8);
            Graphic.printString(terminal, "-Chose attack value", TEXT_X_RIGHT, 12);
            Graphic.printString(terminal, "-Press Enter to lock in", TEXT_X_RIGHT, 13);
            Graphic.printString(terminal, "To regain stamina, chose", TEXT_X_RIGHT, 16);
            Graphic.printString(terminal, "\"Defend\", you can't deal", TEXT_X_RIGHT, 17);
            Graphic.printString(terminal, "damage but will take ", TEXT_X_RIGHT, 18);
            Graphic.printString(terminal, "minimum damage yourself.", TEXT_X_RIGHT, 19);

            //Add walls
            for (int i = 70; i < 100; i++) {
                Graphic.printString(terminal, "\u2588", i, 23, Terminal.Color.CYAN);
            }
            for (int i = 0; i <= 70; i++) {
                Graphic.printString(terminal, "\u2588", i, 29, Terminal.Color.CYAN);
                Graphic.printString(terminal, "\u2588", i, 0, Terminal.Color.CYAN);
            }
            for (int i = 1; i < 29; i++) {
                Graphic.printString(terminal, "\u2588", 0, i, Terminal.Color.CYAN);
                Graphic.printString(terminal, "\u2588", 70, i, Terminal.Color.CYAN);
            }

            //Enemy stats
            Graphic.printString(terminal, "You have encountered a " + enemy.getType(), 4, 2);

            //Player stats
            Graphic.printString(terminal, "PLAYER STATS:", TEXT_X_RIGHT, 24);
            Graphic.printString(terminal, "Your weapon:", TEXT_X_RIGHT, 27);
            Graphic.printString(terminal, player.getBestWeapon().toString() + "to damage", TEXT_X_RIGHT, 28);

            //ASCII
            Graphic.printString(terminal, "  _____", TEXT_X_MIDDLE, 10);
            Graphic.printString(terminal, " /     \\", TEXT_X_MIDDLE, 11);
            Graphic.printString(terminal, "| () () |", TEXT_X_MIDDLE, 12);
            Graphic.printString(terminal, " \\  ^  /", TEXT_X_MIDDLE, 13);
            Graphic.printString(terminal, "  |||||", TEXT_X_MIDDLE, 14);
            Graphic.printString(terminal, "  |||||", TEXT_X_MIDDLE, 15);

            needsToPrintInstruction = false;
        }

        //Enemy stats
        Graphic.printString(terminal, "-Health: " + enemy.getHealth() + " ", 6, 4);

        //Combat texts
        if (playerAttack == 0)
            Graphic.printString(terminal, "You will Defend this turn!", 24, 21);
        else
            Graphic.printString(terminal, "How hard will you hit?:  " + playerAttack, 24, 21);
        if (enemyAttack != -1) {
            Graphic.printString(terminal, "Enemy hits for... " + enemyAttack, 24, 22);
        }
        //Player stats
        Graphic.printString(terminal, "Health: " + player.getHealth() + " ", TEXT_X_RIGHT, 25);
        Graphic.printString(terminal, "Stamina: " + player.getStamina(), TEXT_X_RIGHT, 26);
    }
}
