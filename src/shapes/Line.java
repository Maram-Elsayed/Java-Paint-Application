/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import paintapp.Shape;

/**
 *
 * @author Dodo
 */
public class Line extends Shape {

    private Point endPoint;

    public double calcLength(Point start, Point end) {
        int x = start.getX() - end.getX();
        int y = start.getY() - end.getY();
        double l = Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2)));
        return l;
    }

    public Line() {

    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Line(Point endPoint, Point startPoint, boolean isFilled, Color shapeColor) {
        super(startPoint, isFilled, shapeColor);
        this.endPoint = endPoint;
    }
//public boolean containsLine(int x,int y)
//{ 
//    if(y==getStartPoint().getY()){
//        if(getStartPoint().getX()<=x&&x<=getEndPoint().getX())
//    return true;
//        else if(getStartPoint().getX()>=x&&x>=getEndPoint().getX())
//                return true;
//    }
//        else if(x==getStartPoint().getX()){
//        if(getStartPoint().getY()<=y&&y<=getEndPoint().getY())
//    return true;
//        else if(getStartPoint().getY()>=y&&y>=getEndPoint().getY())
//                return true;
//    }
//    
//    return false;
//}

    public void select(Line l, Graphics g) {
        g.fillRect(l.getStartPoint().getX() - 7, l.getStartPoint().getY() - 7, 14, 14);
        g.fillRect(l.getEndPoint().getX() - 7, l.getEndPoint().getY() - 7, 14, 14);

    }

    public boolean inStart(Point p) {
       Rectangle2D r= new Rectangle2D.Double(startPoint.getX()-7, startPoint.getY()-7, 14, 14);
        if(r.contains(p.getX(), p.getY()))
        {
            return true;
        }
return false;
    }

    public boolean inEnd(Point p) {
        Rectangle2D r= new Rectangle2D.Double(endPoint.getX()-7, endPoint.getY()-7, 14, 14);
        if(r.contains(p.getX(), p.getY()))
        {
            return true;
        }
return false;

        
    }
    public void draw(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
