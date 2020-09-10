//import the libraries for drawing shapes 
import java.awt.*;
import objectdraw.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Shape.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The shape class is an abstract class to implement the 
//                    concrete shapes Circle, Square, and Triangle.  
//
///////////////////////////////////////////////////////////////////////////////

/**
 * The shape class is an abstract class to implement the 
 *  concrete shapes Circle, Square, and Triangle
 **/
public abstract class Shape extends ActiveObject{

  private String shapeName; // the shape identification name

  /**
   * constructor to one argument a String and 
   * assigns to the instance "shape"
   * @param shapeName the shape to assign to
   * */
  public Shape(String shapeName){
    this.shapeName = shapeName;
  }

  /**
   * no args constructor to set the shapeName
   * to default "NoName"
   * */
  public Shape(){
    this("NoName");
  }

  /**
   * the getShape name method is a getter method 
   * to return the String shapeNme 
   * @return shapeName the name of shape
   * */
  public String getShapeName(){
    return this.shapeName;
  }

  /**
   * the draw method is an abstract method taking 
   * three arguments as DrawingCanvas, Color and boolean
   * @param theCanvas the canvas to draw
   * @param shapeColor the color 
   * @param isFilled is the shape filled 
   * */
  public void draw(DrawingCanvas theCanvas, Color shapeColor, boolean isFilled){
  }

}



