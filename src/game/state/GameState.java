package game.state;

import core.Size;
import farm.FarmBoard;
import game.GamePanel;
import input.KeyHandler;
import map.GameMap;

//real time update of the game
public class GameState extends State {

    //defeat conditions
    private boolean playing;

    public GameState(KeyHandler keyHandler, GamePanel gamePanel) {
        super(keyHandler);
        playing = true;
        gameMap = new GameMap(spriteLibrary);
        farmBoard = new FarmBoard(this, gamePanel);
    }



    //playing conditions dito ilalagay
}
