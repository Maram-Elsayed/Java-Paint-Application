/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import paintapp.PaintArea;
import paintapp.State;

/**
 *
 * @author Dodo
 */
public class DrawLineState implements State{

    @Override
    public void doAction(PaintArea p) {
p.currentShape=1;

    }
    
    
}