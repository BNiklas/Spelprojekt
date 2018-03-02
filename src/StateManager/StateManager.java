package StateManager;

import GameObject.GameObject;
import GameObject.Characters.Player;
import StateManager.StateHolder.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;


public class StateManager {
    private State menuState = new MenuState();
    private State adventureState = new AdventureState();
    private State currentState;

    private Terminal terminal;

    public void onInit(Terminal terminal) {
        this.terminal = terminal;

        changeCurrentState(States.MENU_STATE);
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
            if(instruction.getNewStateID() == States.COMBAT_STATE) {
                exitState();
                GameObject[] fighter = instruction.getGameObjects();
                CombatState temp = new CombatState();
                temp.setFighters(fighter[0], fighter[1]);
                enterState(temp);
                return;
            }

            if(instruction.getNewStateID() == States.GAMEOVER_STATE) {
                exitState();
                enterState(new GameoverState((Player) instruction.getGameObjects()[0]));
                return;
            }

            if(instruction.getChangeState()) {
                changeCurrentState(instruction.getNewStateID());
            }
        }
    }

    public void onDraw() {
        currentState.onDraw(terminal);
    }

    private void changeCurrentState(States stateID) {
        exitState();
        switch (stateID) {
            case MENU_STATE:
                enterState(menuState);
                break;
            case ADVENTURE_STATE:
                enterState(adventureState);
                break;
            case COMBAT_STATE:
                // should never happen
                enterState(new CombatState());
                break;
            case GAMEOVER_STATE:
                // should never happen
                enterState(new GameoverState(null));
                break;
        }
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
