package controller;

import input.KeyHandler;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private KeyHandler keyHandler;

    public PlayerController(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
    @Override
    public boolean isRequestingUp() {
        return keyHandler.isPressed(KeyEvent.VK_W);
    }

    @Override
    public boolean isRequestingDown() {
        return keyHandler.isPressed(KeyEvent.VK_S);
    }

    @Override
    public boolean isRequestingLeft() {
        return keyHandler.isPressed(KeyEvent.VK_A);
    }

    @Override
    public boolean isRequestingRight() {
        return keyHandler.isPressed(KeyEvent.VK_D);
    }
}
