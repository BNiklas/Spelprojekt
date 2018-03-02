package StateManager;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

enum States {
    MENU_STATE,
    ADVENTURE_STATE,
    COMBAT_STATE
}

public class StateManager {
    private State menuState = new MenuState();
    private State adventureState = new AdventureState();
    private State combatState = new CombatState();
    private State currentState;

    private Terminal terminal;

    public void onInit(Terminal terminal) {
        adventureState.onInit();
        combatState.onInit();

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
                enterState(combatState);
                break;
        }
    }

    private void enterState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    private void exitState() {
        if (currentState != null) {
            currentState.exit();
            terminal.clearScreen();
        }
    }
}
