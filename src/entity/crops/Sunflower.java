package entity.crops;

import game.state.State;

public class Sunflower extends FarmCrop{
    public Sunflower(State state) {
        super("Sunflower", "Flower", 3, 20, 7.5, 0, 2,
                3, 0, 1, 2, false, 0,
                1, 19, state);
    }
}
