package EX2;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class OlympicRing {

    public OlympicRing(){}

    public void draw(Graphics2D g2){
        Ellipse2D.Double blueRing = new Ellipse2D.Double(5,5,100,100);
        Ellipse2D.Double blackRing = new Ellipse2D.Double(107.5,5,100,100);
        Ellipse2D.Double redRing = new Ellipse2D.Double(210,5,100,100);
        Ellipse2D.Double yellowRing = new Ellipse2D.Double(57.5,55,100,100);
        Ellipse2D.Double greenRing = new Ellipse2D.Double(160,55,100,100);

        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.BLUE);
        g2.draw(blueRing);
        g2.setColor(Color.BLACK);
        g2.draw(blackRing);
        g2.setColor(Color.RED);
        g2.draw(redRing);
        g2.setColor(Color.YELLOW);
        g2.draw(yellowRing);
        g2.setColor(Color.GREEN);
        g2.draw(greenRing);

        
    }
    
}
