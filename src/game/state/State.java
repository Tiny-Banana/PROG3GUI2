package game.state;

import entity.GameObject;
import farm.FarmBoard;
import gfx.SpriteLibrary;
import input.Input;
import map.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected Input input;
    protected FarmBoard farmBoard;

    public State(Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        farmBoard = new FarmBoard();
    }

    //update every action in the game
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
        handleMouseInput();
        //update farmboard to player

    }

    private void handleMouseInput() {
        if (getInput().isMouseClicked()) {
            System.out.println("clicked");
        }
        input.clearMouseClick();
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Input getInput() {
        return input;
    }

    public FarmBoard getFarmBoard() {
        return farmBoard;
    }
}
