/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import shapes.Square;
import shapes.Rectangle;
import shapes.Line;
import shapes.Triangle;
import shapes.Ellipse;
import java.awt.Color;
import paintapp.Shape;

/**
 *
 * @author Dodo
 */
public class ShapeFactory {
    private ShapeFactory(){
        
    }
    private static ShapeFactory uniqueSahpeFactory;
    public static ShapeFactory  getInstance(){
        if(uniqueSahpeFactory==null)
            uniqueSahpeFactory=new ShapeFactory();
        return uniqueSahpeFactory;
    }
    public Shape getShape(String ShapeType){
        if(ShapeType==null){
            return null;
        }
        if(ShapeType.equalsIgnoreCase("line")){
            return new Line();
        }
         if(ShapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
          if(ShapeType.equalsIgnoreCase("Square")){
            return new Square();
        }
          if(ShapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }
          if(ShapeType.equalsIgnoreCase("ellipse")){
            return new Ellipse();
        }if(ShapeType.equalsIgnoreCase("triangle")){
            return new Triangle();
        }
          
         return null;
    }
    
}
