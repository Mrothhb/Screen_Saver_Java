import java.awt.*; 
import objectdraw.*;
import java.util.*;

/**
 * This class is provided for your convenience. It is a nested class where
 * the outer class named Test extends WindowController and
 * the inner class named TestRunner extends ActiveObject. This is necessary for
 * animations to draw with delays.
 */
public class Test extends WindowController{
  /**
   * This is the single method that the Test instance runs, and all we do is
   * a constructor call to TestRunner. No need to save the reference of TestRunner.
   */
  public void begin(){
    new TestRunner(canvas);
  }

  /**
   * This is an inner class definition used only by class Test. It contains
   * the instance variable DrawingCanvas. We cannot pass arguments to
   * TestRunner.run(), so this is the only way we can pass values to it.
   */
  public class TestRunner extends ActiveObject {
    private DrawingCanvas canvas;

    /**
     * Constructor for TestRunner. All it does is set the canvas (no setter needed) and
     *  does a method call to start().
     *
     * start() will end up calling run() implicitly, don't do a direct call to run().
     *
     * @param canvas the reference of the canvas where we will draw.
     */
    public TestRunner(DrawingCanvas canvas){
      this.canvas = canvas;
      start();
    }


    /**
     * TODO PUT YOUR TEST CALLS HERE
     */
    public void run(){

      System.out.println(
      "This is the run method in the TestRunner class, which is an inner class within the class Test.");
      
/*
      // Test Line Draw
      Line8B l = new Line8B(
       new Point(0,0), 
       new Point(500, 500), 
       "Zeniba"
       );
 
      l.draw(canvas, Color.BLUE, true);

      // Test Line Draw
      Line8B l2 = new Line8B(
       new Point(0,500), 
       new Point(500, 0), 
       "Yubaba"
       );

      l2.draw(canvas, Color.RED, true);
*/
      //create a Circle object with given arguments 
      Circle circle = new Circle(new Point(50,50), 25);

      circle.drawBullsEye(canvas, true, 5);

      //test the toString for the circle 
      System.out.println(circle);

      Triangle tri = new Triangle(new Point(200,0), 
          new Point(400,200), new Point(0,200));
      tri.drawTriforce(canvas, true, 4);

      // Test toString() of line:
    
/*
      //test the Square object 
      Square square = new Square(50, 50, 50, "Square");
      square.drawGrid(canvas, true, 4);
      System.out.println(square);

     */
      
    }
  }
}

