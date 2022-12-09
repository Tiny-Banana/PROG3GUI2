package entity.crops;

import game.state.State;

public class Turnip extends FarmCrop {
    public Turnip(State state) {
        super("Turnip", "Root Crop", 2, 5, 5, 0, 1,
                2, 0, 0, 1, false, 0,
                2, 6, state);
    }
}
