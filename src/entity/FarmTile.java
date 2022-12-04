package entity;

import core.Position;
import game.GamePanel;
import game.state.State;
import input.ActionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FarmTile extends GameObject {

    Player player;
    private Image sprite;
    private FarmCrop plantedFarmCrop;
    private boolean isPlowed;
    private boolean rock;
    private JLabel objectLabel;
    private JPopupMenu popupMenu;
    private JMenu[] menu;
    //crop

    //player, and controller
    public FarmTile(State state, int x, int y) {
        this.plantedFarmCrop = null;
        this.isPlowed  = false;
        this.rock = false;

        this.sprite = state.getGameMap().getTileImage()[1].getSprite();
        this.player = state.getPlayer();
        this.setPosition(new Position(x, y));
        this.objectName = "tile";
        this.objectLabel = new JLabel();
        this.objectLabel.setBounds(x, y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);

        state.getGameObjects().add(this);

//        plantedFarmCrop = new FarmCrop(state);
//        state.getGameObjects().add(plantedFarmCrop);
    }

    public JLabel getObjectLabel() {
        return objectLabel;
    }

    private void addMenuItems() {
        menu[0] = new JMenu("Plow");
        menu[0].addActionListener(new ActionHandler());
        menu[0].setActionCommand("plow");

        menu[1] = new JMenu("Plant");


        menu[2] = new JMenu("Water");
        menu[2].addActionListener(new ActionHandler());
        menu[2].setActionCommand("water");

        popupMenu.add(menu[0]);
        popupMenu.add(menu[1]);
        popupMenu.add(menu[2]);
    }


    private void displayPopUp() {
        this.popupMenu = new JPopupMenu();
        this.menu = new JMenu[3];
        addMenuItems();
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(objectLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }


    @Override
    public void update() {
        //update player's position in accordance to the controller
        //player.update();

        //menu item
    }

    @Override
    public Image getSprite() {
        return sprite;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

}
