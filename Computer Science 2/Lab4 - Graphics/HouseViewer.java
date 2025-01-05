package EX1;

import javax.swing.*;

public class HouseViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setTitle("House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HouseComponent component = new HouseComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
