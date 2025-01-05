package EX1;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HouseComponent extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        House house = new House();
        house.draw(g2);
    }
}
