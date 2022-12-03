package farm;

import farm.crops.Crop;
import input.Input;

import javax.swing.*;

public class FarmTile  {
    private Crop plantedCrop;
    private boolean isPlowed;
    private boolean rock;
    private JButton button;

    public FarmTile() {
        plantedCrop = null;
        isPlowed  = false;
        rock = false;
    }

    private void initializeButton(Input input) {
        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setVisible(true);
        //button.addMouseListener(input);
    }

    //update the tile
    public void update() {

    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

    public JButton getButton() {
        return button;
    }
}
