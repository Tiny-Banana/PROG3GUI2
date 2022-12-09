package entity.crops;

import game.state.State;

public class Carrot extends FarmCrop {
    public Carrot(State state) {
        super("Carrot", "Root Crop", 3, 10, 7.5, 0, 1,
                2, 0, 0, 1, false, 0,
                2, 9, state);
    }
}
