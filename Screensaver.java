import java.util.ArrayList;
import java.util.Random;
import objectdraw.ActiveObject;
import objectdraw.DrawingCanvas;
import objectdraw.WindowController;
import java.awt.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Screensaver.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Screensaver class will create a sequence of 
//                    random shapes and designs on the java output
//                    canvas. The screen saver will continue forever
//                    until the user quits. 
//
///////////////////////////////////////////////////////////////////////////////
/**
 * The Screensaver class will create a sequence of 
 * random shapes and designs on the java output
 * canvas. The screen saver will continue forever
 * until the user quits. 
 *
 */
public class Screensaver extends WindowController {

  public void begin() {
    new Animation(canvas);
  }

  public class Animation extends ActiveObject {

    private static final int DELAY = 250;
    private DrawingCanvas canvas;
    Random random = new Random();

    public Animation(DrawingCanvas canvas) {
      this.canvas = canvas;
      start();
    }

    /**
     * the getter method for a Shapes arraylist 
     * to return the list containing the Circle,
     * Square and Triangle objects 
     * @return shapes the list of shapes
     * */
    private ArrayList<Shape> populateList() {

      final int EIGHT = 8;
      final int FOUR = 4;
      final int TEN = 10;
      
      //create a list of shape objects 
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      // the bounds on the canvas not to be exceeded

      int bounds = 0;

      //check wether the height or width is greater on the canvas
      if(this.canvas.getHeight() > this.canvas.getWidth())
        bounds = this.canvas.getHeight();
      else 
        bounds = this.canvas.getWidth();
      
      for(int i = 0; i<TEN; i++){
        
        //add the Circle, Square and Triangle in that order 
        //for each iteration
        int circleSize = random.nextInt(bounds/(EIGHT - 1));

        Point circlePoint = new Point(random.nextInt(bounds),
            random.nextInt(bounds));        
        shapes.add(new Circle(circlePoint, circleSize));

        //Add randomly sized squares to random points
        int squareSize = random.nextInt(bounds/(EIGHT - 1));
        Point squarePoint = new Point(random.nextInt(bounds),
            random.nextInt(bounds));        
        shapes.add(new Square(squarePoint, squareSize));

        //Add randomly sized triangles to random points
        Point p1 = new Point(random.nextInt(bounds),
            random.nextInt(bounds));
        Point p2 = new Point(random.nextInt(bounds/FOUR - 1),
            p1.getY());
        Point p3 = new Point(random.nextInt(bounds/FOUR - 1),
            random.nextInt(bounds/FOUR - 1));
        shapes.add(new Triangle(p1, p2, p3));
        
      }

      return shapes;
    }

    /**
     * private getter method for 
     * color in the shapes
     * @return randomColor color 
     * */
    private Color getColor(){
      Random random = new Random();
      final int maxColor = 255;
      Color randomColor = new Color(random.nextInt(maxColor),
          random.nextInt(maxColor), random.nextInt(maxColor));
      return randomColor;
    }

    /**
     * the void method for drawCanvas will take 
     * a shapes arraylist as an arguement and draw 
     * all the shapes contained onto the canvas 
     * @param list the list of shapes
     * */
    public void drawCanvas(ArrayList<Shape> list) {
      final int RATIO = 4;
      final int CAP = 3;
      final int DELAY = 25;
      //create a random color using private helper method 
      Color color = getColor();
      int randomNumber = random.nextInt(RATIO);
      //create a random n value for recursion cap at 3
      int n = random.nextInt(CAP);
      //the 75% rate for fill or not fill on all shapes  
      boolean fill = true;
      //iterate through the list and draw each shape on the canvas
      for(int i = 0; i<list.size(); i++){
        //if the shape is a Circle, then cast down into a Circle 
        //and call the Circle methods to draw on canvas 
        if(list.get(i) instanceof Circle){
          Circle tempCircle = (Circle)list.get(i);
          pause(DELAY);
          tempCircle.draw(canvas,color,fill);
          pause(DELAY);
          tempCircle.drawBullsEye(canvas, fill, n);
          //if the shape is a Square then cast down to a Square 
          //and call the methods to draw on canvas 
        }else if(list.get(i) instanceof Square){
          Square tempSquare = (Square)list.get(i);
          pause(DELAY);
          tempSquare.draw(canvas, color, fill);
          pause(DELAY);
          tempSquare.drawGrid(canvas, fill, n);
          //if the shape is a Triangle then cast down to Triangle
          //and call the methods to draw on the canvas 
        }else if(list.get(i) instanceof Triangle){
          Triangle tempTri = (Triangle)list.get(i);
          pause(DELAY);
          tempTri.draw(canvas, color, fill);
          pause(DELAY);
          tempTri.drawTriforce(canvas, fill, n);
        }
        //choose a new random n value for next iteration  
        n = random.nextInt(CAP);
        //choose a new random color for next iteration 
        color = getColor();

        //three out of 4 times the fill method will be called. 
        //a random number between 1 and 4 is generated, and the 
        //probability of fill is 75%. if the number is not 1, then
        //fill. 
        randomNumber = random.nextInt(RATIO);
        if(randomNumber == 1)
          fill = false;
        else
          fill = true;

      }

    }

    /** 
     * the void method run will draw the shapes 
     * onto the canvas and clear them after theyre all
     * finsihed being drawn on screen and then loop
     * forever until user quits
     * */
    public void run() {
      while (true) {

        this.drawCanvas(this.populateList());

        this.canvas.clear();
      }

    }
  }
}
