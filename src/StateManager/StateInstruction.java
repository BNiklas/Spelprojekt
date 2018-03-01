package StateManager;

import GameObject.GameObject;

import java.util.List;

class StateInstruction {
    private boolean changeState;
    private States newStateID;
    private List<GameObject> gameObjects;

    public boolean getChangeState() {
        return changeState;
    }

    public States getNewStateID() {
        return newStateID;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    StateInstruction(States newState, List<GameObject> gameObjects) {
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
