package display;

import entity.Player;
import game.GamePanel;

import java.awt.*;

public class UI {
    Player player;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;

    public UI(Player player) {
        this.player = player;


        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_80B  = new Font("Arial", Font.BOLD, 20);
    }

    public void showMessage(String text) {
//        message = text;
//        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        drawCharacterScreen();
    }


    public void drawCharacterScreen() {
        //CREATE A FRAME
        final int FRAME_X = GamePanel.TILE_SIZE * 2;
        final int FRAME_Y = GamePanel.TILE_SIZE;
        final int FRAME_WIDTH = GamePanel.TILE_SIZE * 5;
        final int FRAME_HEIGHT = GamePanel.TILE_SIZE * 5;
        drawSubWindow(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);

        //TEXT
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(16F));

        int textX = FRAME_X + 20;
        int textY = FRAME_Y + GamePanel.TILE_SIZE;
        final int lineHeight = 32;

        //NAMES
        g2.drawString("Farmer Type", textX, textY);
        textY += lineHeight;
        g2.drawString("Experience", textX, textY);
        textY += lineHeight;
        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Days Playing", textX, textY);
        textY += lineHeight;
        g2.drawString("ObjectCoins", textX, textY);

        //VALUES
        int tailX = (FRAME_X + FRAME_WIDTH) - 30;
        //RESET textY
        textY =  FRAME_Y + GamePanel.TILE_SIZE;
        String value;

        value = player.getFarmerType();
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getExperience());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getLevel());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getDaysPlaying());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getObjectcoins());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color color = new Color(0, 0, 0, 210);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforAlign(String text, int tailX) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return tailX - length;
    }

}

