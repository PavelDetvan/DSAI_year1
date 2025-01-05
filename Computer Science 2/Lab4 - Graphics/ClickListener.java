package EX3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener{
    private int counter = 0;

    public void actionPerformed(ActionEvent event) {
        counter++;
        System.out.println("I was clicked "+counter+" times.");
        }
}
