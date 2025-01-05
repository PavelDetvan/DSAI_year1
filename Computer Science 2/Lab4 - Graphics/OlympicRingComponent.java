package EX2;


import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class OlympicRingComponent extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        OlympicRing rings = new OlympicRing();
        rings.draw(g2);
    }
}
