package entity.crops;

import game.state.State;

public class Rose extends FarmCrop{
    public Rose(State state) {
        super("Rose", "Flower", 1, 5, 2.5, 0, 1,
                2, 0, 0, 1, false, 0,
                1, 5, state);
    }
}
