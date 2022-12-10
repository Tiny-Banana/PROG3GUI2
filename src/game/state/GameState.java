package game.state;

import controller.Controller;
import core.Size;
import farm.FarmBoard;
import game.GamePanel;
import input.KeyHandler;
import map.GameMap;

//real time update of the game
public class GameState extends State {

    //defeat conditions
    private boolean playing;

    public GameState(KeyHandler keyHandler, Controller controller, GamePanel gamePanel) {
        super(keyHandler, controller);
        playing = true;
        gameMap = new GameMap(spriteLibrary);
        farmBoard = new FarmBoard(this, gamePanel);
    }



    //playing conditions dito ilalagay
}
