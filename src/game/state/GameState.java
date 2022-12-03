package game.state;

import controller.PlayerController;
import entity.Player;
import input.Input;
import map.GameMap;

//real time update of the game
public class GameState extends State {

    //defeat conditions
    private boolean playing;

    public GameState(Input input) {
        super(input);
        playing = true;
        Player player = new Player(new PlayerController(input), spriteLibrary);
        gameObjects.add(player);
        gameMap = new GameMap(spriteLibrary);
        initializeFarmBoard();
    }

    private void initializeFarmBoard() {

    }

    //playing conditions dito ilalagay


}
