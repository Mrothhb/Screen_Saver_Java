import java.awt.*;
import objectdraw.*;
import java.util.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Triangle.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        the Triangle class will create a shape out of 
//                    Line8B objects and either fill it with color 
//                    or leave it empty. The triangle also has the method
//                    to implement a Triforce shape 
//
///////////////////////////////////////////////////////////////////////////////

/**
 * the Triangle class will create a shape out of 
 * Line8B objects and either fill it with color 
 * or leave it empty. The triangle also has the method
 * to implement a Triforce shape 
 * */

public class Triangle extends Shape{

  //three private points for the triangle 
  private Point p1;
  private Point p2;
  private Point p3;

  /**
   * the constructor will accept three arguments 
   * and all three will be Points
   * @param p1 point 1
   * @param p2 point 2
   * @param p3 point 3
   * */
  public Triangle(Point p1, Point p2, Point p3){
    super();
    this.p1 = new Point(p1);
    this.p2 = new Point(p2);
    this.p3 = new Point(p3);
  }

  /**
   * the constructor will accept four arguments 
   * and all three will be Points, and one will be 
   * a String for the Shape name 
   * @param p1 point 1
   * @param p2 point 2
   * @param p3 point 3
   * @param name the name of shape
   * */
  public Triangle(Point p1, Point p2, Point p3, String name){
    super(name);
    this.p1 = new Point(p1);
    this.p2 = new Point(p2);
    this.p3 = new Point(p3);
  }

  /**
   * the constructor will accept one argument as
   * a Triangle object and is a deep copy constructor
   * @param originalTriangle the triangle object to copy 
   *
   * */
  public Triangle(Triangle originalTriangle){
    this.p1 = new Point((originalTriangle.getP1()));
    this.p2 = new Point((originalTriangle.getP2()));
    this.p3 = new Point((originalTriangle.getP3()));
  }

  /**
   * the constructor will accept two arguments 
   * one will be a triangle object and the other
   * will be a String as the name of shape, this is 
   * also a deep copy constructor 
   * @param p1 point 1
   * @param originalTriangle the triangle object to copy 
   * @param name the name of shape 
   * */
  public Triangle(Triangle originalTriangle, String name){
    super(name);
    this.p1 = new Point((originalTriangle.getP1()));
    this.p2 = new Point((originalTriangle.getP2()));
    this.p3 = new Point((originalTriangle.getP3()));
  }

  /**
   * the no args constructor default the 
   * name to NoName 
   * */
  public Triangle(){
    this(new Point(), new Point(), new Point());  

  }

  /**
   * the getP1 method will return the p1
   * point
   * @return this.p1 point 1
   * */
  public Point getP1(){
    return this.p1;
  }
  /**
   * the getP2 method will return the p1
   * point
   * @return this.p2 point 2
   * */
  public Point getP2(){
    return this.p2;
  }
  /**
   * the getP3 method will return the p1
   * point
   * @return this.p3 point 3
   * */
  public Point getP3(){
    return this.p3;
  }

  /**
   * the fill method will fill the triangle 
   * if the fill parameter is set to true 
   * when the draw method is called
   * @param canvas the canvas to draw on
   * @param color the color of triangles
   *
   * */
  private void fill(DrawingCanvas canvas, Color color){
    //the amount of iterations to make for triangle
    double STEPS = 400;
    //the change in x and y as we move across from p2 to p3 in triangle
    double x_delta = Math.abs(getP3().getX()-getP2().getX())/STEPS;
    double y_delta = Math.abs(getP3().getY()-getP2().getY())/STEPS;
    //the x and y that will have incremented values over the number of steps
    double x = x_delta;
    double y = y_delta;
    //iterate "STEPS" amount of times, and generate new lines at each 
    //tiny point created until the entire triangle is filled with lines
    for(int i = 0; i<(int)STEPS; i++){    
        Point p = new Point((getP3().getX() + (int)x), 
            (getP3().getY() + (int)y));
        Line8B l = new Line8B(getP1(), p);
      	l.draw(canvas, color, true);
        x = x+x_delta;
        y = y+y_delta;
    }    
  }

  /**
   * the draw method will override the draw method 
   * from Shape. The method will take three arguments 
   * @param theCanvas the canvas to draw
   * @param shapeColor the color 
   * @param filled is the shape filled 
   * */
  public void draw(DrawingCanvas canvas, Color color, boolean fill){

    //create three new lines that will be the shape of the triangle 
    //this will represent the frame of the triangle 
    Line8B line1 = new Line8B(getP1(), getP2());
    Line8B line2 = new Line8B(getP2(), getP3());
    Line8B line3 = new Line8B(getP3(), getP1());
    // draw all three lines onto the screen 
    line1.draw(canvas, color, true);
    line2.draw(canvas, color, true);
    line3.draw(canvas, color, true);
    //if the fill parameter is true, then call the fill method to 
    //fill the triangle with color 
    if(fill)
      this.fill(canvas, color);

  }

   /**
   * private helper method to get a random Color 
   * object and return the color to be filled in the
   * Triangle 
   * @return randomColor the color 
   * */
  private Color getColor(){
    Random random = new Random();
    final int maxColor = 255;
    Color randomColor = new Color(random.nextInt(maxColor),
        random.nextInt(maxColor), random.nextInt(maxColor));
    return randomColor;
  }

  /**
   * the drawTriforce method will draw a triforce 
   * triangle using similar logic as the draw method
   * with added recursion 
   * @param canvas the canvas to draw on
   * @param fill true false to fill triangle
   * @param n the number of iterations
   * */
  public void drawTriforce(DrawingCanvas canvas, boolean fill, int n){
    //create a color randomly 
    Color color = getColor();
  
     // the following block is temp x and y coordinates for the new
     // point that will be generated for each interior triangle 
     // the x and y will be the midpoint between each P1 and P2 etc. 

     int tempP1x = ((this.getP1().getX() + this.getP2().getX())/2);
     int tempP1y = ((this.getP1().getY() + this.getP2().getY())/2);
     int tempP2x = ((this.getP1().getX() + this.getP3().getX())/2);
     int tempP2y = ((this.getP1().getY() + this.getP3().getY())/2);
     int tempP3x = ((this.getP2().getX() + this.getP3().getX())/2);
     int tempP3y = ((this.getP2().getY() + this.getP3().getY())/2);

     //make three Points with the generated new x and y coordinates 
     Point newP1 = new Point(tempP1x, tempP1y);
     Point newP2 = new Point(tempP2x, tempP2y);
     Point newP3 = new Point(tempP3x, tempP3y);
  //if n is zero then return doinf nothing 
    if(n == 0)
      return;
    //if n is 1 then draw one triangle 
    else if(n == 1){
      Triangle tri = new Triangle(newP1, newP2, newP3);
      tri.draw(canvas, color, fill);
    }
    //if n is greater than 2 
    else{
      Triangle tri = new Triangle(newP1, newP2, newP3);
      tri.draw(canvas, color, fill);
      //create three new points and set the points equal to the 
      //instance variable points 
      this.p1 = new Point(newP1);
      this.p2 = new Point(newP2);
      this.p3 = new Point(newP3);
      //get a new random color 
      color = getColor();
      //recrusively call the same method again if n i greater than 1      
      drawTriforce(canvas, fill, n-1);
    }
   
  }

  /**
   * the toString method will return a String 
   * representation of the Triangle object Overriding
   * the shape class
   * */
  public String toString(){

    return "Triangle Object's Name: " + this.getShapeName() + "\n"
            + "Vertices: " + this.getP1() + ";" + " " 
            + this.getP2() + ";" + " " + this.getP3() + "\n";
  }

}
