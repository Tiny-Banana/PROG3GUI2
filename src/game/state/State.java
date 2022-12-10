package game.state;

import controller.PlayerController;
import entity.GameObject;
import entity.Player;
import farm.FarmBoard;
import gfx.SpriteLibrary;
import input.KeyHandler;
import map.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected KeyHandler keyHandler;
    protected Player player;
    protected FarmBoard farmBoard;

    public State(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        this.gameObjects = new ArrayList<>();
        this.spriteLibrary = new SpriteLibrary();
        this.player = new Player(new PlayerController(keyHandler), spriteLibrary);
    }

    //update every action in the game
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
        //update farmboard to player
    }
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    public GameMap getGameMap() {
        return gameMap;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
    public Player getPlayer() {
        return player;
    }

    public FarmBoard getFarmBoard() {
        return farmBoard;
    }
}
