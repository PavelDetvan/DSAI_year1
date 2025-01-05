package EX3;

import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonViewer {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button1 = new JButton("Click me!");
        JButton button2 = new JButton("Click me instead!");
        JPanel panel = new JPanel();

        panel.add(button1);
        panel.add(button2);
        
        
        ActionListener listener1 = new ClickListener();
        button1.addActionListener(listener1);
        ActionListener listener2 = new ClickListener();
        button2.addActionListener(listener2);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
    }
}
