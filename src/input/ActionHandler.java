package input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        switch (choice) {
            case "plow" -> System.out.println("Tile plowed");
            case "water" -> System.out.println("Tile Watered");
        }
    }
}
