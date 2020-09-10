/*
 * Test program for classes Point and Circle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws a Mickey Mouse figure.
 */

import java.awt.*;
import objectdraw.*;

public class Mickey extends WindowController
{
  public void begin()
  {
    try
    {
      makeMickey();
    }
    catch ( Exception e )
    {
      String msg1 = "An Exception Occurred!";
      String msg2 = "Check the terminal window";
      String msg3 = "for details!";

      Text errorMsg1 = new Text( msg1, 25, 200, canvas );
      Text errorMsg2 = new Text( msg2, 25, 225, canvas );
      Text errorMsg3 = new Text( msg3, 25, 250, canvas );

      errorMsg1.setColor( Color.RED );
      errorMsg1.setFontSize( 32 );
      errorMsg1.setBold( true );

      errorMsg2.setColor( Color.RED );
      errorMsg2.setFontSize( 32 );
      errorMsg2.setBold( true );

      errorMsg3.setColor( Color.RED );
      errorMsg3.setFontSize( 32 );
      errorMsg3.setBold( true );

      e.printStackTrace();
    }
  }

  public void makeMickey()
  {
    Shape c1, c2, c3;  // these are generic Shapes
    Circle c4;
    Point p1, p2, p3;

    // Test Point no-arg ctor - should be (0,0)
    p1 = new Point();

    if ( p1.getX() != 0 || p1.getY() != 0 )
    {
      String s = "\nThis should not print!!!\n"
               + "Testing Point no-arg ctor\n"
               + "Should be (0,0)\n";

      throw new IllegalStateException( s );
    }


    // Test Circle no-arg ctor - should set center to (0,0) with radius 0
    c1 = new Circle();

    if ( ((Circle)c1).getRadius() != 0 ||
         ((Circle)c1).getCenter().getX() != 0 ||
         ((Circle)c1).getCenter().getY() != 0 )
    {
      String s = "\nThis should not print!!!\n"
               + "Testing Circle no-arg ctor\n"
               + "Center point should be (0,0) with radius 0\n";

      throw new IllegalStateException( s );
    }

    /* Mickey's head */
    p1 = new Point( canvas.getWidth()/2, canvas.getHeight()/2 );
    c1 = new Circle( p1, 100, "Circle" );
    c1.draw( canvas, Color.BLACK, true );  // black and filled


    // Test if Circle ctor did shallow copy (incorrect) vs. deep copy (correct)
    if ( ((Circle)c1).getCenter() == p1 )    // shallow copy - No No
    {
      String s = "\nYou implemented the Circle ctor with a shallow copy.\n"
                 + "Should be deep copy!\n";

      throw new IllegalStateException( s );
    }

    p2 = new Point( canvas.getWidth()/2-100, canvas.getWidth()/2-100 );       // test Point copy ctor


    /* Mickey's left ear */
    c2 = new Circle( p2, 50, "Circle" );
    c2.draw( canvas, Color.BLACK, true );  // black and filled

    p3 = new Point ( canvas.getWidth()/2+100, canvas.getWidth()/2-100 );      // test Point copy ctor


    /* Mickey's right ear */
    c3 = new Circle( p3, 50, "Circle" );
    c3.draw( canvas, Color.BLACK, true );  // black and filled
    



    c4 = new Circle( (Circle) c1 , "Circle");  // test Circle copy ctor

    if ( ((Circle)c4).getCenter() == ((Circle)c1).getCenter() )
    {
      String s = "\nYou implemented the Circle copy ctor with a "
               + "shallow copy.\n"
               + "Should be deep copy.\n";

      throw new IllegalStateException( s );
    }

    /* Display info about Mickey's head */
    Text text1 = new Text( c4.toString(), c4.getCenter().getX(),
                           c4.getCenter().getY() + c4.getRadius() + 20,
                           canvas );

    text1.move( -text1.getWidth()/2, 0 );  // center text under circle
    


    if ( c2.getClass() == Circle.class )
    {
      c4 = (Circle) c2;

      /* Display info about Mickey's left ear */
      Text text2 = new Text( c4.toString(), c4.getCenter().getX(),
                             c4.getCenter().getY() - c4.getRadius() - 40,
                             canvas );

      text2.move( -text2.getWidth()/2, 0 );  // center text over circle
    }
    else
    {
      throw new RuntimeException( String.valueOf( c2 ) );
    }


    if ( c3 instanceof Circle )
    {
      c4 = (Circle) c3;

      /* Display info about Mickey's right ear */
      Text text3 = new Text( c4.toString(), c4.getCenter().getX(),
                             c4.getCenter().getY() - c4.getRadius() - 20,
                             canvas );

      text3.move( -text3.getWidth()/2, 0 );  // center text over circle
    }
    else
    {
      throw new RuntimeException( String.valueOf( c3 ) );
    }


  }  // End of makeMickey()

} // End of class 
