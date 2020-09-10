/**
 * Hans Yuan
 * CSE 8B
 * Spring 2018
 *
 * This file contains the definition for the class Line 8B. Use this file as a reference
 * for how your future files may look.
 */

import java.awt.*;
import objectdraw.*;

/**
 * Defines the class Line8B which is simply two points. That is enough information to draw a line
 * using the objectdraw library. We inherit from shape.
 */
public class Line8B extends Shape
{
  // Field Variables 
  private Point start;
  private Point end;

  // Constructors using Points

  /**
   * Constructor that takes two points. It doesn't matter which point is on which side.
   * @param start a Point coordinate
   * @param end a Point coordinate
   */
  public Line8B (Point start, Point end){
    this (start, end, "NoName");
  }

  /**
   * Constructor that takes two points. It doesn't matter which point is on which side.
   * It simply calls the superclass constructor, and the current-class other constructor.
   * @param start a Point coordinate
   * @param end a Point coordinate
   * @param name a String to be this shape's name
   */
  public Line8B (Point start, Point end, String name){
    super (name);
    this.start = (new Point(start));
    this.end = (new Point(end));
    

  }

  /**
   * takes an original line, makes a deep copy, sets the default name
   * @param originalLine a Line8B object which we want to make a deep copy
   */
  public Line8B(Line8B originalLine)
  {
    super ("NoName");
    this.start = (new Point (originalLine.getStart ()));
    this.end = (new Point (originalLine.getEnd ()));
  }

  /**
   * takes an original line, makes a deep copy, sets a custom name
   * @param originalLine a Line8B object which we want to make a deep copy
   * @param name a String to be this shape's name
   */
  public Line8B(Line8B originalLine, String name)
  {
    super (name);
    this.start =  (new Point(originalLine.getStart ()));
    this.end =  (new Point(originalLine.getEnd ()));
  }

  /**
   * Lazy Constructor, all default values
   */
  public Line8B(){

    // Which constructor is this calling? The second constructor and the
    // only constructor taking in three parameters as input.
    this( new Point( 0, 0 ), new Point( 0, 0 ), "NoName" );
  }


  // Getters

  /**
   * get start point
   * @return start point
   */
  public Point getStart(){
    return this.start;
  }

  /**
   * gets end point
   * @return end point
   */
  public Point getEnd(){
    return this.end;
  }
  

  /**
   * Draw method doing API call to objectdraw lib.
   * @param canvas the reference to the Canvas on which the drawings are done
   * @param color the Color that the line will be drawn with
   * @param fill an unused parameter just to satisfy overriding from Shape (bad software design)
   */
  @Override
  public void draw(DrawingCanvas canvas, Color color, boolean fill)
  {
    // note that fill is unused -- that's special for the line. 
    // Line is a class from objectdraw, hence the reason why this class is 
    // called Line8B
    Line line = new Line( 
          getStart().getX(), 
          getStart().getY(),
          getEnd().getX(), 
          getEnd().getY(), 
          canvas 
          );

    if ( color != null )  line.setColor( color );
    else              line.setColor( Color.BLACK );

  }

  // This is to help make testing

  /**
   * example call: System.out.println(myLine8B); will do a method call to
   * this method and print this string to the shell. Use this to debug.
   * @return the String representation of this object includes name and points.
   */
  @Override
  public String toString(){
    return "Line Object's Name: " + getShapeName() + "\n" + 
      "Start Point: " + getStart() + "\n" + 
      "End Point: " + getEnd() + "\n"; 
  }
}
