/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import paintapp.Shape;

/**
 *
 * @author Dodo
 */
public class Rectangle extends Shape {

    public Rectangle(int height, int width, Point startPoint, boolean Filled, Color shapeColor) {
        super(startPoint, Filled, shapeColor);
        this.height = height;
        this.width = width;
    }

    private int height,width;

    Rectangle() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    


//
//    @Override
//    public Graphics2D resize(Graphics2D g2d, Shape s) {
//        Rectangle r=(Rectangle)s;
//        String input1=JOptionPane.showInputDialog("Please Enter the ratio of width");
//              String input2=JOptionPane.showInputDialog("Please Enter the ratio of hieght");
//            int inputX =Integer.parseInt(input1);
//            int inputY =Integer.parseInt(input2);
//                     
// g2d = (Graphics2D)g2d.create(r.getStartPoint().getX(), r.getStartPoint().getY(),inputX* r.getWidth(),inputY* r.getHeight());
//       return g2d;
//}

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
