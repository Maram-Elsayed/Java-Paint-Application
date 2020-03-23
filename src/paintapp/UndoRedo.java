
package paintapp;


/**
 *
 * @author user
 */
public class UndoRedo {
   private final int maxSize=100;
   private Shape[] stackArray;
   private int top;
   
    public UndoRedo() {
        stackArray=new Shape[maxSize];
      top=-1;
    }

   
    public void push(Shape j) {
      stackArray[++top] = j;
   }
    public Shape pop() {
      return stackArray[top--];
   }
}
