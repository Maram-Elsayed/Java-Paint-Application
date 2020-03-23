/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import Iterator.Container;
import Iterator.ShapesIterator;
import Iterator.Iterator;
import shapes.Circle;
import shapes.ShapeFactory;
import shapes.Square;
import shapes.Rectangle;
import shapes.Line;
import shapes.Point;
import shapes.Triangle;
import shapes.Ellipse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import static paintapp.Frame.filled;


/**
 *
 * @author Dodo
 */
public class PaintArea extends javax.swing.JPanel implements Container{

    /**
     * Creates new form PaintArea
     */
    public static ArrayList<Shape> shapes = new ArrayList<Shape>();
    int currentShape,mode=-1;
    int select=1,draw=0,resize=2;
    
    Shape willBeResized;
    Stack<Shape> stack1=new Stack<Shape>();
    Stack<Shape> stack2=new Stack<Shape>();
    Color currentColor=Color.BLACK;
    Shape selected=null;
    Point a;
    Point b;
    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        if(currentState!=null)
        {
            currentState.doAction(this);
        }
        
    }
    protected ShapeFactory factory= ShapeFactory.getInstance();
ArrayList<Observer> observers=new ArrayList<>();
ArrayList<String> History=new ArrayList<>();

    public void attatch( Observer o){
        observers.add(o);
    }
    public void NotifyAll(){
//         Iterator i=getIterator();
//        while(i.hasNext()) {
//            Observer o =(Observer)i.next();
for(Observer o:observers)
{
    o.update();
}
    }
    public void addHistory(String s){
        History.add(s);
        notifyAll();
    }
    
    

    public PaintArea() {
        initComponents();
    }
    

    @Override
    protected void paintComponent(Graphics g) {//draws first 
        super.paintComponent(g);
       Iterator i=getIterator();
        while(i.hasNext()) {
            Shape shape=(Shape)i.next();
            g.setColor(shape.getShapeColor());
            
          //  shape.setIsFilled(filled);
            if (shape instanceof Line) {
                Line l = (Line) shape;
                g.drawLine(l.getStartPoint().getX(), l.getStartPoint().getY(), l.getEndPoint().getX(), l.getEndPoint().getY());

            } else if (shape instanceof Ellipse) {
                Ellipse e = (Ellipse) shape;
                if (e.isFilled()) {
                    g.fillOval(e.getStartPoint().getX(), e.getStartPoint().getY(), e.getWidth(), e.getHeight());
                } else {
                    g.drawOval(e.getStartPoint().getX(), e.getStartPoint().getY(), e.getWidth(), e.getHeight());
                }
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                if (r.isFilled()) {
                    g.fillRect(r.getStartPoint().getX(), r.getStartPoint().getY(), r.getWidth(), r.getHeight());
                } else {
                    g.drawRect(r.getStartPoint().getX(), r.getStartPoint().getY(), r.getWidth(), r.getHeight());
                }
            } else if (shape instanceof Square) {
                Square s = (Square) shape;
                if (s.isFilled()) {
                    g.fillRect(s.getStartPoint().getX(), s.getStartPoint().getY(), s.getSide(), s.getSide());
                } else {
                    g.drawRect(s.getStartPoint().getX(), s.getStartPoint().getY(), s.getSide(), s.getSide());
                }
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                if (c.isFilled()) {
                    g.fillOval(c.getStartPoint().getX(), c.getStartPoint().getY(), c.getDiameter(), c.getDiameter());
                } else {
                    g.drawOval(c.getStartPoint().getX(), c.getStartPoint().getY(), c.getDiameter(), c.getDiameter());
                }
            }else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                Polygon p = new Polygon();
                p.addPoint(t.getP1().getX(), t.getP1().getY());
                p.addPoint(t.getP2().getX(), t.getP2().getY());
                p.addPoint(t.getStartPoint().getX(), t.getStartPoint().getY());
                if (t.isFilled()) {
g.fillPolygon(p);              
                } else {
g.drawPolygon(p);                }
                
            }
        

        stack1.push(shape);
        }

        
         }
    public static void copyPaintComponent(Shape shape,Graphics g) {
               
            g.setColor(shape.getShapeColor());          
            if (shape instanceof Line) {
                Line l = (Line) shape;
                g.drawLine(l.getStartPoint().getX()+13,l.getStartPoint().getY()+305, l.getEndPoint().getX()+13, l.getEndPoint().getY()+305);
                
            } else if (shape instanceof Ellipse) {
                Ellipse e = (Ellipse) shape;
                if (e.isFilled()) {
                    g.fillOval(e.getStartPoint().getX()+13, e.getStartPoint().getY()+305, e.getWidth(), e.getHeight());
                } else {
                    g.drawOval(e.getStartPoint().getX()+13, e.getStartPoint().getY()+305, e.getWidth(), e.getHeight());
                }
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                if (r.isFilled()) {
                    g.fillRect(r.getStartPoint().getX()+13, r.getStartPoint().getY()+305, r.getWidth(), r.getHeight());
                } else {
                    g.drawRect(r.getStartPoint().getX()+13, r.getStartPoint().getY()+305, r.getWidth(), r.getHeight());
                }
            } else if (shape instanceof Square) {
                Square s = (Square) shape;
                if (s.isFilled()) {
                    g.fillRect(s.getStartPoint().getX()+13, s.getStartPoint().getY()+305, s.getSide(), s.getSide());
                } else {
                    g.drawRect(s.getStartPoint().getX()+13, s.getStartPoint().getY()+305, s.getSide(), s.getSide());
                }
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                if (c.isFilled()) {
                    g.fillOval(c.getStartPoint().getX()+13, c.getStartPoint().getY()+305, c.getDiameter(), c.getDiameter());
                } else {
                    g.drawOval(c.getStartPoint().getX()+13, c.getStartPoint().getY()+305, c.getDiameter(), c.getDiameter());
                }
            }else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                Polygon p = new Polygon();
                p.addPoint(t.getP1().getX()+13, t.getP1().getY()+305);
                p.addPoint(t.getP2().getX()+13, t.getP2().getY()+305);
                p.addPoint(t.getStartPoint().getX()+13, t.getStartPoint().getY()+305);
                if (t.isFilled()) {
g.fillPolygon(p);              
                } else {
g.drawPolygon(p);                }
                
            }

        shapes.add(shape);
    }
    public static void paintComponent(Graphics g,Shape shape) {
               
            g.setColor(shape.getShapeColor());          
            if (shape instanceof Line) {
                Line l = (Line) shape;
                g.drawLine(300, 350, l.getEndPoint().getX(), l.getEndPoint().getY());

            } else if (shape instanceof Ellipse) {
                Ellipse e = (Ellipse) shape;
                if (e.isFilled()) {
                    g.fillOval(e.getStartPoint().getX(), e.getStartPoint().getY(), e.getWidth(), e.getHeight());
                } else {
                    g.drawOval(e.getStartPoint().getX(), e.getStartPoint().getY(), e.getWidth(), e.getHeight());
                }
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                if (r.isFilled()) {
                    g.fillRect(r.getStartPoint().getX(), r.getStartPoint().getY(), r.getWidth(), r.getHeight());
                } else {
                    g.drawRect(r.getStartPoint().getX(), r.getStartPoint().getY(), r.getWidth(), r.getHeight());
                }
            } else if (shape instanceof Square) {
                Square s = (Square) shape;
                if (s.isFilled()) {
                    g.fillRect(s.getStartPoint().getX(), s.getStartPoint().getY(), s.getSide(), s.getSide());
                } else {
                    g.drawRect(s.getStartPoint().getX(), s.getStartPoint().getY(), s.getSide(), s.getSide());
                }
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                if (c.isFilled()) {
                    g.fillOval(c.getStartPoint().getX(), c.getStartPoint().getY(), c.getDiameter(), c.getDiameter());
                } else {
                    g.drawOval(c.getStartPoint().getX(), c.getStartPoint().getY(), c.getDiameter(), c.getDiameter());
                }
            }else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                Polygon p = new Polygon();
                p.addPoint(t.getP1().getX(), t.getP1().getY());
                p.addPoint(t.getP2().getX(), t.getP2().getY());
                p.addPoint(t.getStartPoint().getX(), t.getStartPoint().getY());
                if (t.isFilled()) {
g.fillPolygon(p);              
                } else {
g.drawPolygon(p);                }
                
            }

        shapes.add(shape);
    }
    public static void resizePaintComponent(Shape shape,Graphics2D g) {
               
            g.setColor(shape.getShapeColor());
            if (shape instanceof Line) {             //re look at
                
                Line l = (Line) shape;
 String scale=JOptionPane.showInputDialog("Please Enter new length");                
    if(scale!=null){
        double sc=Double.parseDouble(scale);
       l.getEndPoint().setX((int)sc+l.getStartPoint().getX());
       l.getEndPoint().setY((int)sc+l.getStartPoint().getY());
      double length=l.calcLength(l.getStartPoint(), l.getEndPoint());
                g.scale(length, length);
                g.drawLine(l.getStartPoint().getX()+13, l.getStartPoint().getY()+305, l.getEndPoint().getX(), l.getEndPoint().getY());
    }
                } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                String diameter=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* diameter");                
                if(diameter!=null){
                double newDiameter=Double.parseDouble(diameter)*c.getDiameter();
                g.scale(newDiameter, newDiameter);
                c.setDiameter((int)newDiameter);
                if (c.isFilled()) {
                    g.fillOval(c.getStartPoint().getX()+13, c.getStartPoint().getY()+305, c.getDiameter(), c.getDiameter());
                } else {
                    g.drawOval(c.getStartPoint().getX()+13, c.getStartPoint().getY()+305, c.getDiameter(), c.getDiameter());
                }
                }
            } else if (shape instanceof Ellipse) {
                Ellipse e = (Ellipse) shape;
                String width=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* Width");
                String height=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* Hieght");
                double w=Double.parseDouble(width)*e.getWidth();
                double h=Double.parseDouble(height)*e.getHeight();
                g.scale(w,h);   
                e.setHeight((int)h);
                e.setWidth((int)w);
                if (e.isFilled()) {
                    g.fillOval(e.getStartPoint().getX()+13, e.getStartPoint().getY()+305, e.getWidth(), e.getHeight());
                } else {
                    g.drawOval(e.getStartPoint().getX()+13, e.getStartPoint().getY()+305, e.getWidth(), e.getHeight());
                }
                } else if (shape instanceof Square) {
                Square s = (Square) shape;
                 String sidelength=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* side length"); 
                 double side=Double.parseDouble(sidelength)*s.getSide();
                g.scale(side,side);   
                s.setSide((int)side);
                if (s.isFilled()) {
                    g.fillRect(s.getStartPoint().getX()+13, s.getStartPoint().getY()+305, s.getSide(), s.getSide());
                } else {
                    g.drawRect(s.getStartPoint().getX()+13, s.getStartPoint().getY()+305, s.getSide(), s.getSide());
                }
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                String width=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* width");
                String height=JOptionPane.showInputDialog("Please Enter new scale, Note:scale* Hieght");
               double w=Double.parseDouble(width)*r.getWidth();
              
                double h=Double.parseDouble(height)*r.getHeight();
                g.scale(w,h);   
               
             r.setHeight((int)h);
                r.setWidth((int)w);
               
                if (r.isFilled()) {
                    g.fillRect(r.getStartPoint().getX()+13, r.getStartPoint().getY()+305, r.getWidth(), r.getHeight());
                } else {
                    g.drawRect(r.getStartPoint().getX()+13, r.getStartPoint().getY()+305, r.getWidth(), r.getHeight());
                    
                }
            
            }else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                String scale=JOptionPane.showInputDialog("Please Enter width");
                String height=JOptionPane.showInputDialog("Please Enter hieght");
                double sc=Double.parseDouble(scale);
                double h=Double.parseDouble(height);
       t.getP1().setX((t.getStartPoint().getX()));
       t.getP1().setY(((int)h+t.getStartPoint().getY()));
       t.getP2().setX(((int)sc+t.getStartPoint().getX()));
       t.getP2().setY(((int)h+t.getStartPoint().getY()));
       
      double length1=t.calcLength(t.getStartPoint(), t.getP1());
            double length2=t.calcLength(t.getP1(), t.getP2());

                g.scale(length1, length2);
                                
                Polygon p = new Polygon();
                p.addPoint(t.getP1().getX(), t.getP1().getY());
                p.addPoint(t.getP2().getX(), t.getP2().getY());
                p.addPoint(t.getStartPoint().getX()+13, t.getStartPoint().getY()+305);
                if (t.isFilled()) {
g.fillPolygon(p);              
                } else {
g.drawPolygon(p);                }
                
            }

        shapes.add(shape);
    }    
   public void undo(){
       if(!stack1.isEmpty()){
           Shape s= stack1.pop();
           stack2.push(s);
           shapes.remove(s);
           repaint();
       }
   }
   public void redo(){
       if(!stack2.isEmpty()){
           Shape s= stack2.pop();
           stack1.push(s);
           Graphics temp=this.getGraphics();        
      PaintArea.paintComponent(temp,s);
           repaint();
       }
   }

    public void deleteAll() {
        shapes.clear();
        
repaint();
    }
   public void deleteSelected(){
       if(selected!=null){
           shapes.remove(selected);
          
    
repaint();
       }
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
   
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        b = new Point(evt.getX(), evt.getY());
        if(mode==draw){
            if (currentShape == 1) {
                Line line = (Line) shapes.get(shapes.size() - 1);
                line.setEndPoint(b);
                repaint();
            } else if (currentShape == 2) {
                Ellipse ellipse = (Ellipse) shapes.get(shapes.size() - 1);
                if (b.getX() < a.getX() && b.getY() < a.getY()) {
                    ellipse.setStartPoint(b);
                } else if (b.getX() > a.getX() && b.getY() < a.getY()) {
                    Point start = new Point(a.getX(), b.getY());
                    ellipse.setStartPoint(start);
                } else if (b.getX() < a.getX() && b.getY() > a.getY()) {
                    Point start = new Point(b.getX(), a.getY());
                    ellipse.setStartPoint(start);
                }
                ellipse.setWidth(Math.abs(b.getX() - a.getX()));
                ellipse.setHeight(Math.abs(b.getY() - a.getY()));
                repaint();

            } else if (currentShape == 3) {
                Rectangle rectangle = (Rectangle) shapes.get(shapes.size() - 1);
                if (b.getX() < a.getX() && b.getY() < a.getY()) {
                    rectangle.setStartPoint(b);
                } else if (b.getX() > a.getX() && b.getY() < a.getY()) {
                    Point start = new Point(a.getX(), b.getY());
                    rectangle.setStartPoint(start);
                } else if (b.getX() < a.getX() && b.getY() > a.getY()) {
                    Point start = new Point(b.getX(), a.getY());
                    rectangle.setStartPoint(start);
                }
                rectangle.setWidth(Math.abs(b.getX() - a.getX()));
                rectangle.setHeight(Math.abs(b.getY() - a.getY()));
                repaint();

            } else if (currentShape == 4) {
                Square square = (Square) shapes.get(shapes.size() - 1);
                if (b.getX() < a.getX() && b.getY() < a.getY()) {
                    square.setStartPoint(b);
                } else if (b.getX() > a.getX() && b.getY() < a.getY()) {
                    Point start = new Point(a.getX(), b.getY());
                    square.setStartPoint(start);
                } else if (b.getX() < a.getX() && b.getY() > a.getY()) {
                    Point start = new Point(b.getX(), a.getY());
                    square.setStartPoint(start);
                }
                square.setSide(Math.abs(b.getX() - a.getX()));

                repaint();

            } else if (currentShape == 5) {
                Circle circle = (Circle) shapes.get(shapes.size() - 1);
                if (b.getX() < a.getX() && b.getY() < a.getY()) {
                    circle.setStartPoint(b);
                } else if (b.getX() > a.getX() && b.getY() < a.getY()) {
                    Point start = new Point(a.getX(), b.getY());
                    circle.setStartPoint(start);
                } else if (b.getX() < a.getX() && b.getY() > a.getY()) {
                    Point start = new Point(b.getX(), a.getY());
                    circle.setStartPoint(start);
                }
                circle.setDiameter(Math.abs(b.getX() - a.getX()));
                repaint();

            }
            else if(currentShape==6)
            {Triangle t=(Triangle)shapes.get(shapes.size() - 1);
            t.setP1(b);
            t.setP2(new Point(a.getX(),b.getY()));
            repaint();
            }
        }else if(mode==select) {
            if(selected!=null) {
                
                if(selected  instanceof Triangle) {
                    Triangle t=(Triangle)selected;
                    Point newStart= new Point(t.getStartPoint().getX(), t.getStartPoint().getY());
                    newStart.setX(newStart.getX()+b.getX()-a.getX());
                    newStart.setY(newStart.getY()+b.getY()-a.getY());
                     Point p1=new Point(b.getX()-a.getX()+t.getP1().getX(),b.getY()-a.getY()+t.getP1().getY());
                    Point p2=new Point(b.getX()-a.getX()+t.getP2().getX(),b.getY()-a.getY()+t.getP2().getY());
                 
//                    Point p1=new Point(t.getStartPoint().getX(),newStart.getY()+t.getP1().getY()-t.getStartPoint().getY());
//                    Point p2=new Point(t.getStartPoint().getX()+Math.abs(t.getP2().getX()-t.getP1().getX()),newStart.getY()+t.getP2().getY()-t.getStartPoint().getY());

//                    System.out.println("Start x:" + newStart.getX());
//                    System.out.println("Start y:" + newStart.getY());
//                    System.out.println("p1 x:" + p1.getX());
//                    System.out.println("p1 y:" + p1.getY());
//                    System.out.println("p2 x:" + p2.getX());
//                    System.out.println("p2 y:" + p2.getY());

                    t.setStartPoint(newStart);
                    t.setP2(p2);
                    t.setP1(p1);
                    a=new Point(evt.getX(),evt.getY());
                    
                    repaint();   
                } else if(selected instanceof Line)
                {
                    Line l=(Line)selected;
                    Point newStart= new Point(l.getStartPoint().getX(), l.getStartPoint().getY());
                    newStart.setX(newStart.getX()+b.getX()-a.getX());
                    newStart.setY(newStart.getY()+b.getY()-a.getY());
                    Point p1=new Point(b.getX()-a.getX()+l.getEndPoint().getX(),b.getY()-a.getY()+l.getEndPoint().getY());
                    l.setStartPoint(newStart);
                    l.setEndPoint(p1);
                    a=new Point(evt.getX(),evt.getY());
                    
                    repaint();   
                }else {
                    Point newStart= new Point(selected.getStartPoint().getX(), selected.getStartPoint().getY());
                    newStart.setX(newStart.getX()+b.getX()-a.getX());
                    newStart.setY(newStart.getY()+b.getY()-a.getY());
                    selected.setStartPoint(newStart);
                    a=new Point(evt.getX(),evt.getY());
                    repaint();
                }
            }
                       
 
        }
      
    
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
               this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        a = new Point(evt.getX(), evt.getY());
        
        if(mode==draw){
        if (currentShape == 1) {
            Line l =(Line) factory.getShape("line");
            l.setStartPoint(a);
            l.setEndPoint(a);
            l.setShapeColor(currentColor);
            l.setIsFilled(filled);
            shapes.add(l);
            repaint();
        } else if (currentShape == 2) {
            Ellipse e =(Ellipse)factory.getShape("ellipse");
            e.setStartPoint(a);
            e.setHeight(0);
            e.setWidth(0);
            e.setShapeColor(currentColor);
            e.setIsFilled(filled);
            shapes.add(e);

            repaint();

        } else if (currentShape == 3) {
            Rectangle r = (Rectangle)factory.getShape("rectangle");
            r.setStartPoint(a);
            r.setHeight(0);
            r.setWidth(0);
            r.setShapeColor(currentColor);
            r.setIsFilled(filled);
            shapes.add(r);

            repaint();
        } else if (currentShape == 4) {
            Square s = (Square)factory.getShape("square");
            s.setStartPoint(a);
            s.setSide(0);
            s.setShapeColor(currentColor);
            s.setIsFilled(filled);
            shapes.add(s);

            repaint();
        } else if (currentShape == 5) {
            Circle c = (Circle)factory.getShape("Circle");
            c.setStartPoint(a);
            c.setDiameter(0);
            c.setShapeColor(currentColor);
            c.setIsFilled(filled);
            shapes.add(c);

            repaint();
        }
        else if (currentShape ==6)
        {
            Triangle t=(Triangle)factory.getShape("triangle");
            t.setStartPoint(a);
            t.setP1(a);
            t.setP2(a);
            t.setShapeColor(currentColor);
            t.setIsFilled(filled);
            shapes.add(t);

            repaint();
        }}
         if(selected!=null)
            {this.setCursor(new Cursor(Cursor.MOVE_CURSOR));

            }else this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                       
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        Point p=new Point(evt.getX(),evt.getY());
        
        if(mode==select)
        {
            Iterator i=getIterator();
        while(i.hasNext()) {
            Shape s=(Shape)i.next();
//            for(i=shapes.size()-1;i>=0;i--)
//            {
//                Shape s=shapes.get(i);
                if(s instanceof Circle)
                        {
                            Circle c=(Circle)s;
                            Ellipse2D e=new Ellipse2D.Double(c.getStartPoint().getX(), c.getStartPoint().getY(), c.getDiameter(), c.getDiameter());
                       if(e.contains(p.getX(), p.getY()))
                       { selected=s;
            this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                       break;
                       }
                        }
                if(s instanceof Ellipse)
                        {
                            Ellipse E=(Ellipse)s;
                            Ellipse2D ellipse=new Ellipse2D.Double(E.getStartPoint().getX(), E.getStartPoint().getY(), E.getHeight(), E.getWidth());
                       if(ellipse.contains(p.getX(), p.getY()))
                       {selected=s;
                       this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                       break;}
                        }
                 if(s instanceof Line)
                        {
                            Line l=(Line)s;
                            Rectangle2D rect=new Rectangle2D.Double(l.getStartPoint().getX(), l.getStartPoint().getY(), Math.abs(l.getStartPoint().getX()-l.getEndPoint().getX()), Math.abs(l.getStartPoint().getY()-l.getEndPoint().getY()));
                       if(rect.contains(p.getX(), p.getY()))
                           { 
                               selected=s;
                                       this.setCursor(new Cursor(Cursor.MOVE_CURSOR));

                       break;}
                        }
                 if(s instanceof Square)
                        {
                            Square sqr=(Square)s;
                            Rectangle2D square=new Rectangle2D.Double(sqr.getStartPoint().getX(), sqr.getStartPoint().getY(), sqr.getSide(),  sqr.getSide());
                       if(square.contains(p.getX(), p.getY()))
                           { selected=s;
                  this.setCursor(new Cursor(Cursor.MOVE_CURSOR));

                       break;}
                        }
                       if(s instanceof Rectangle)
                        {
                            Rectangle rect=(Rectangle)s;
                            Rectangle2D rectangle=new Rectangle2D.Double(rect.getStartPoint().getX(), rect.getStartPoint().getY(), rect.getWidth(), rect.getHeight());
                       if(rectangle.contains(p.getX(), p.getY()))
                           { selected=s;
                            this.setCursor(new Cursor(Cursor.MOVE_CURSOR));

                       break;}
                        }
                       if(s instanceof Triangle)
                        {
                            Triangle tri=(Triangle)s;
        Rectangle2D rectangle=new Rectangle2D.Double(tri.getStartPoint().getX(), tri.getStartPoint().getY(),Math.abs(tri.getP1().getX()-tri.getP2().getX()) ,Math.abs(tri.getP1().getY()-tri.getStartPoint().getY()));

                       if(rectangle.contains(p.getX(), p.getY()))
                           { selected=s;
             this.setCursor(new Cursor(Cursor.MOVE_CURSOR));

                       break;}
                        }
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            }
                       
                
      
             
        
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

            } @Override
    public Iterator getIterator() {
   return  new ShapesIterator();
         }  

   
}
