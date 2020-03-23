/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import paintapp.Shape;

/**
 *
 * @author Dodo
 */
public class Triangle extends Shape{
    private Point p1,p2;
   public double calcLength(Point start,Point end){
    int x=start.getX()-end.getX();
        int y=start.getY()-end.getY();
        double l=Math.sqrt((Math.pow(x,2))+(Math.pow(y, 2)));
        return l;
}
    public Triangle(Point p1, Point p2, Point startPoint, boolean isFilled, Color shapeColor) {
        super(startPoint, isFilled, shapeColor);
        this.p1 = p1;
        this.p2 = p2;
    }

    Triangle() {
    }

    

    

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    
    

   

    
    public void draw(Shape s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

    

