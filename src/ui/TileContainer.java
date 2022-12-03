package ui;

import core.Size;
import game.GamePanel;

public class TileContainer extends UIContainer {

    public TileContainer(Size windowSize) {
        super(windowSize);
        margin = new Spacing(0);
        padding = new Spacing(0);
    }

    @Override
    protected Size calculateContentSize() {
        return new Size(GamePanel.TILE_SIZE,GamePanel.TILE_SIZE);
    }

    @Override
    protected void calculateContentPosition() {
    }
}
