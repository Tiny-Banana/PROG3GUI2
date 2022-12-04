package input;

import java.awt.event.*;

public class KeyHandler implements KeyListener{

    private boolean[] pressed;

    public KeyHandler() {
        pressed = new boolean[1000];
    }

    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }
}
