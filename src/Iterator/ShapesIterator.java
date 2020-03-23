/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import Iterator.Iterator;
import static paintapp.PaintArea.shapes;

/**
 *
 * @author Dodo
 */
public class ShapesIterator implements Iterator{
   int index;
   
    @Override
    public Object next() {
     if(hasNext()){
      return shapes.get(index++);  
}
    return null;
    }

    @Override
    public boolean hasNext() {
if(index<shapes.size()) 
{
    return true;
} return false;
    }
    
}
