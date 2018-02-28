package StateManager;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class StateManager {
    private State adventureState = new AdventureState();
    private State combatState = new CombatState();
    private State currentState;

    public void onInit() {
        adventureState.onInit();
        combatState.onInit();

        changeCurrentState(1);
    }

    public void onInput(Key key) {
        currentState.onInput(key);
    }

    public void onLoop() {
        currentState.onLoop();
    }

    public void onDraw(Terminal terminal) {
        currentState.onDraw(terminal);
    }

    private void changeCurrentState(int stateID) {
        exitState();
        switch (stateID) {
            case 1:
                enterState(adventureState);
                break;
            case 2:
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
        }
    }
}
