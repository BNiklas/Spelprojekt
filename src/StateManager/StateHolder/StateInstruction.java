package StateManager.StateHolder;

import GameObject.GameObject;

public class StateInstruction {
    private StateManager.States newStateID;
    private GameObject[] gameObjects;


    public StateManager.States getNewStateID() {
        return newStateID;
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public StateInstruction(StateManager.States newState, GameObject[] gameObjects) {
        this.newStateID = newState;
        this.gameObjects = gameObjects;
    }

    StateInstruction(StateManager.States newState) {
        this.newStateID = newState;
    }
}
