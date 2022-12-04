package farm;

import entity.FarmTile;
import game.GamePanel;
import game.state.State;

import java.io.*;
/**
 * This class handles the board manipulation.
 *
 * @author Jomar Delos Reyes
 * @version 1.0
 * @since 11/07/2022
 */
public class FarmBoard {

    private FarmTile[][] farmTile;
    private State state;

    public FarmBoard(State state, GamePanel gamePanel) {
        this.farmTile = new FarmTile[10][5];
        this.state = state;
        initializeBoard(gamePanel);
    }

    private void initializeBoard(GamePanel gamePanel) {
        int rowStart = 6 * GamePanel.TILE_SIZE;
        int colStart = 2 * GamePanel.TILE_SIZE;

        for (int y = 0; y < 10; y++) {
            for (int x = 0 ; x < 5; x++) {
                int tileX = GamePanel.TILE_SIZE * x + rowStart;
                int tileY = GamePanel.TILE_SIZE * y + colStart;
                farmTile[y][x] = new FarmTile(state,tileX, tileY);
                state.getGameObjects().add(getFarmTile(y, x));
                gamePanel.add(getFarmTile(y, x).getObjectLabel());
            }
        }
    }

    /**
     * Scatter rocks all throughout the game board determined by a text file input
     */
    public void scatterRocks() {
        try {
            InputStream is = getClass().getResourceAsStream(("/maps/scatter.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Boolean.parseBoolean(br.readLine()))
                        farmTile[i][j].setRock(true);
                }
            }
        } catch (Exception e){

        }
    }

    public FarmTile getFarmTile(int row, int column) {
        return farmTile[row][column];
    }
}