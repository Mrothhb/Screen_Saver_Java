/**
 * Hans Yuan
 * CSE 8B
 * Spring 2018
 *
 * This file contains the definition for the class Point. Use this file as a reference
 * for how your future files may look. This is not a shape, it does not have a name.
 *
 * Essentially, this is simply a class definition for a pair of integers. Since PSA 5
 * deals with coordinates, it makes sense to encapsulate pairs of ints within a class
 * and abstract out all the manual logic with double integers.
 */
public class Point
{
  private int x;
  private int y;

  /**
   * Create a new Point with two ints
   * @param x int x_coordinate
   * @param y int y_coordinate
   */
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
   * Create a new point at (0,0).
   */
  public Point() {
    this( 0, 0 );
  }

  /**
   * Deep constructor of an originalPoint object.
   * @param originalPoint a Point object which we want a deep copy of
   */
  public Point (Point originalPoint){
    this.x = (originalPoint.getX());
    this.y = (originalPoint.getY());
  }

  /**
   * getter for x_coordinate
   * @return x_coordinate
   */
  public int getX()
  {
    return this.x;
  }

  /**
   * getter for y_coordinate
   * @return y_coordinate
   */
  public int getY()
  {
    return this.y;
  }

  /**
   * example call: System.out.println(myPoint); will do a method call to
   * this method and print this string to the shell. Use this to debug.
   * @return the String representation of this object includes x_coordinate and y_coordinate.
   */
  @Override
  public String toString()
  {
    return "Point: (" + getX() + "," + getY() + ")";
  }

}
