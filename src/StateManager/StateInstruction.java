package StateManager;

import GameObject.GameObject;

import java.util.List;

public class StateInstruction {
    private boolean changeState;
    private States newStateID;
    private GameObject[] gameObjects;

    public boolean getChangeState() {
        return changeState;
    }

    public States getNewStateID() {
        return newStateID;
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public StateInstruction(States newState, GameObject[] gameObjects) {
        this.changeState = true;
        this.newStateID = newState;
        this.gameObjects = gameObjects;
    }

    StateInstruction(States newState) {
        this.changeState = true;
        this.newStateID = newState;
    }

    StateInstruction() {
        this.changeState = false;
    }
}
