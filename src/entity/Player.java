package entity;

import controller.Controller;
import gfx.SpriteLibrary;

public class Player extends MovingEntity {

    public Player(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller, spriteLibrary);
    }

    @Override
    public void update() {
        super.update();
        //pick a tool
        //use a tool sa tile

    }
}
