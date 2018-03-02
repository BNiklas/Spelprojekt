package StateManager.StateHolder;

import GameObject.GameObject;

public class StateInstruction {
    private boolean changeState;
    private StateManager.States newStateID;
    private GameObject[] gameObjects;

    public boolean getChangeState() {
        return changeState;
    }

    public StateManager.States getNewStateID() {
        return newStateID;
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public StateInstruction(StateManager.States newState, GameObject[] gameObjects) {
        this.changeState = true;
        this.newStateID = newState;
        this.gameObjects = gameObjects;
    }

    StateInstruction(StateManager.States newState) {
        this.changeState = true;
        this.newStateID = newState;
    }

    StateInstruction() {
        this.changeState = false;
    }
}
