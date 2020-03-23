/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import shapes.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Stack;


/**
 *
 * @author Dodo
 */
public abstract class  Shape implements Cloneable,Strategy  {
    static Color ShapeColor;
    protected Point startPoint;
    protected boolean  rotate;

    public boolean isRotate() {
        return rotate;
    }

    public void setRotate(boolean rotate) {
        this.rotate = rotate;
    }
boolean selected;
public Shape(){
    
}

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
      

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    protected boolean filled;
     protected Color shapeColor;

    public boolean isFilled() {
        return filled;
    }

    public void setIsFilled(boolean Filled) {
        this.filled = Filled;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
    

    public Shape(Point startPoint, boolean isFilled, Color shapeColor) {
        this.startPoint = startPoint;
        this.filled = isFilled;
        this.shapeColor = shapeColor;
    }

    public Object clone() {
        
	 Object clone=null;
         try {
               clone=super.clone();

	    } catch (CloneNotSupportedException e) {
                e.printStackTrace();
		}
         
		return clone;
	}
  
  
    
}
   
    

