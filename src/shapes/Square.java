/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;

/**
 *
 * @author Dodo
 */
public class Square extends Rectangle {

private int side;

    public Square(int side,  Point startPoint, boolean Filled, Color shapeColor) {
        super(side, side, startPoint, Filled, shapeColor);
        this.side = side;
    }

    Square() {
    }
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
        super.setHeight(side);
        super.setWidth(side);
    }
   
}
