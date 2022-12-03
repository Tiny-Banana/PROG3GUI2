package farm;

import game.GamePanel;
import input.Input;

import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * This class handles the board manipulation.
 *
 * @author Jomar Delos Reyes
 * @version 1.0
 * @since 11/07/2022
 */
public class FarmBoard extends JPanel {

    private FarmTile[][] farmTile;

    public FarmBoard() {
        setBounds(6 * GamePanel.TILE_SIZE, 2 * GamePanel.TILE_SIZE, GamePanel.TILE_SIZE * 5, GamePanel.TILE_SIZE * 10);
        setLayout(null);
        farmTile = new FarmTile[10][5];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0 ; x < 5; x++) {
                farmTile[y][x] = new FarmTile();
                JButton button = new JButton();
                button.setBounds(x * GamePanel.TILE_SIZE, y * GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
                button.setMargin(null);
                add(button);
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