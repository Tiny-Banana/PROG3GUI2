package game;

import display.Display;
import display.Renderer;
import game.state.GameState;
import game.state.State;
import input.Input;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int SCALE = 3;
    public static final int TILE_SIZE = 48; //48 x 48
    public static final int MAX_SCREEN_COL = 17;
    public static final int MAX_SCREEN_ROW = 14;
    public static final int SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE;
    public static final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;
    private final Renderer renderer;

    private Input input;
    private State state;

    private boolean running;
    private final double updateRate = 60;

    public GamePanel() {
        input = new Input();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.black);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(input);
        setLayout(null);

        renderer = new Renderer();

        state = new GameState(input);
        new Display(this);
    }

    @Override
    public void run() {
        running = true;
        double drawInterval = (double) 1000000000 / updateRate;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(running) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update() {
        state.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        renderer.render(state, g2);

        g2.dispose();

    }
}
