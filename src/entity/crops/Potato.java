package entity.crops;

import game.state.State;

public class Potato extends FarmCrop{
    public Potato(State state) {
        super("Potato", "Root Crop", 5, 20, 12.5, 0, 3,
                4, 0, 1, 2, false, 0,
                10,  3, state);
    }
}
