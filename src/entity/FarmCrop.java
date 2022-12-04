package entity;

import core.Position;
import game.state.State;

import java.awt.*;

public class FarmCrop extends GameObject {

    private Image sprite;

    public FarmCrop(State state) {
        this.sprite = state.getGameMap().getTileImage()[3].getSprite();

        setPosition(new Position(100, 100));
    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        return sprite;
    }
}
