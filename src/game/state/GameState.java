package game.state;

import farm.FarmBoard;
import game.GamePanel;
import input.KeyHandler;
import map.GameMap;

//real time update of the game
public class GameState extends State {

    //defeat conditions
    private boolean playing;

    public GameState(KeyHandler keyHandler, GamePanel gamePanel) {
        super(keyHandler, gamePanel);
        playing = true;
        gameMap = new GameMap(spriteLibrary);
        farmBoard = new FarmBoard(this, gamePanel);
        initializeFarmBoard();
    }

    private void initializeFarmBoard() {

    }

    //playing conditions dito ilalagay


}
