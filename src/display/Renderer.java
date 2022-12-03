package display;

import game.GamePanel;
import game.state.State;

import java.awt.*;

public class Renderer {

    public void render(State state, Graphics2D graphics) {
        renderMap(state, graphics);
        renderObject(state, graphics);
    }

    private void renderObject(State state, Graphics2D graphics) {
        state.getGameObjects().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().intX(),
                gameObject.getPosition().intY(),
                GamePanel.TILE_SIZE * GamePanel.SCALE,
                GamePanel.TILE_SIZE * GamePanel.SCALE,
                null
        ));
    }

    private void renderMap(State state, Graphics graphics) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < GamePanel.MAX_SCREEN_COL && row < GamePanel.MAX_SCREEN_ROW) {
            int tileNum = state.getGameMap().getTileMap()[row][col];

            graphics.drawImage(
                    state.getGameMap().getTileImage()[tileNum].getSprite(),
                    x, y,
                    GamePanel.TILE_SIZE,
                    GamePanel.TILE_SIZE,
                    null
            );
            col++;
            x += GamePanel.TILE_SIZE;

            if (col == GamePanel.MAX_SCREEN_COL) {
                col = 0;
                x = 0;
                row++;
                y += GamePanel.TILE_SIZE;
            }
        }
    }
}
