package input;

import entity.FarmTile;
import entity.Player;
import event.Event;
import game.state.State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    Event event;
    public ActionHandler(Player player, FarmTile farmTile, State state) {
        this.event = new Event(player, farmTile, state);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        if (choice.equals("plow")) {
            event.plow();
        } else if (choice.equals("turnip") || choice.equals("carrot") || choice.equals("rose")
                || choice.equals("potato") || choice.equals("tulips")) {
            event.plant(choice);
        } else if (choice.equals("water")) {
            event.water();
        } else if (choice.equals("shovel")) {
            event.shovel();
        } else if (choice.equals("pickaxe")) {
            event.pickaxe();
        } else if (choice.equals("fertilize")) {
            event.fertilize();
        } else if (choice.equals("harvest")) {
            event.harvest();
        }
    }
}
