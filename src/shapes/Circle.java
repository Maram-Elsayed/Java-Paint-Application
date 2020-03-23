/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import shapes.Point;
import shapes.Ellipse;
import java.awt.Color;

/**
 *
 * @author Dodo
 */
public class Circle extends Ellipse {

    public Circle(int diameter, Point startPoint, boolean isFilled, Color shapeColor) {
        super(diameter, diameter, startPoint, isFilled, shapeColor);
        this.diameter = diameter;
    }

int diameter;

    Circle() {
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        super.setHeight(diameter);
        super.setWidth(diameter);
    }

   
    
}
