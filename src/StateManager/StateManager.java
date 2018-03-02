package StateManager;

import GameObject.GameObject;
import GameObject.Characters.Player;
import StateManager.StateHolder.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;


public class StateManager {
    private State adventureState = new AdventureState();
    private State currentState;

    private Terminal terminal;

    public void onInit(Terminal terminal) {
        this.terminal = terminal;

        changeCurrentState(new MenuState());
    }

    public void onInput(Key key) {
        currentState.onInput(key);
    }

    public void onLoop() {
        currentState.onLoop();

        handlePotentialExitInstructions();
    }

    private void handlePotentialExitInstructions() {
        if (currentState.hasExitInstructions()) {
            StateInstruction instruction = currentState.getExitInstructions();
            switch (instruction.getNewStateID()) {
                case COMBAT_STATE:
                    GameObject[] fighters = instruction.getGameObjects();
                    changeCurrentState(new CombatState(fighters[0], fighters[1]));
                    break;
                case ADVENTURE_STATE:
                    changeCurrentState(adventureState);
                    break;
                case MENU_STATE:
                    changeCurrentState(new MenuState());
                    break;
                case GAMEOVER_STATE:
                    changeCurrentState(new GameoverState((Player) instruction.getGameObjects()[0]));
                    break;
            }
        }
    }

    public void onDraw() {
        currentState.onDraw(terminal);
    }

    private void changeCurrentState(State newState) {
        exitState();
        enterState(newState);
    }

    private void enterState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    private void exitState() {
        if (currentState != null) {
            terminal.clearScreen();
        }
    }
}
