package EX1;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class House {

    public House(){}

    public void draw(Graphics2D g2){
        Rectangle2D.Double facade = new Rectangle2D.Double(150,250,200,200);
        Line2D.Double roofL = new Line2D.Double(150,250,250,150);
        Line2D.Double roofR = new Line2D.Double(350,250,250,150);
        Rectangle2D.Double door = new Rectangle.Double(180,350,50,100);
        Line2D.Double handle = new Line2D.Double(185,400,190,400);
        Rectangle2D.Double window = new Rectangle2D.Double(280,300,50,50);
        Line2D.Double glassV = new Line2D.Double(305,300,305,350);
        Line2D.Double glassH = new Line2D.Double(280,325,330,325);
        Line2D.Double chimney1 = new Line2D.Double(200,150,200,200);
        Line2D.Double chimney2 = new Line2D.Double(170,150,200,150);
        Line2D.Double chimney3 = new Line2D.Double(170,150,170,230);
        
        g2.draw(facade);
        g2.setColor(Color.RED);
        g2.draw(roofR);
        g2.draw(roofL);
        g2.setColor(Color.ORANGE);
        g2.draw(door);
        g2.setColor(Color.BLACK);
        g2.draw(handle);
        g2.setColor(Color.BLUE);
        g2.draw(window);
        g2.draw(glassH);
        g2.draw(glassV);
        g2.setColor(Color.BLACK);
        g2.draw(chimney1);
        g2.draw(chimney2);
        g2.draw(chimney3);
    }
}
