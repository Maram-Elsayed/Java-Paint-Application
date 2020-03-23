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
public class Ellipse extends Shape{
 private int height,width;

    Ellipse() {
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public Ellipse(int height, int width, Point startPoint, boolean isFilled, Color shapeColor) {
        super(startPoint, isFilled, shapeColor);
        this.height = height;
        this.width = width;
    }

   

 

    @Override
    public void draw() {
    }

}
