import java.awt.*; 
import objectdraw.*;
import java.util.*;

public class FallenStar extends WindowController{ 
  public void begin(){
    new Drawer(canvas);
  }

  // This is an inner class definition used only by class Test.
  public class Drawer extends ActiveObject {
    private DrawingCanvas canvas;

    public Drawer(DrawingCanvas canvas){
      this.canvas = canvas;
      start();
    }

    public void run(){

      int textVerticalOffset = 40;


      
      // the buildings in the back

      Square background = new Square(0,0,600, "Square");
      background.draw(canvas, Color.WHITE, true);
      new Text(background.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square buildingBackSide = new Square(460, 540, 100, "Square");
      buildingBackSide.draw(canvas, new Color(211,211,211), true);
      new Text(buildingBackSide.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square buildingBack = new Square(445, 530, 100,"Square");
      buildingBack.draw(canvas, new Color(120,120,120), true);
      new Text(buildingBack.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square builingMidSide = new Square(320, 470, 150,"Square");
      builingMidSide.draw(canvas, new Color(211,211,211), true);
      new Text(builingMidSide.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square builingMid = new Square(300, 450, 150,"Square");
      builingMid.draw(canvas, new Color(120,120,120), true);
      new Text(builingMid.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square base = new Square(0,300,300,"Square");
      base.draw(canvas, new Color(211,211,211), true);
      new Text(base.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square baseFront = new Square(-30,300,300,"Square");
      baseFront.draw(canvas, new Color(120,120,120), true);
      new Text(baseFront.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);



      // the circle windows in the front building

      Circle window1 = new Circle(new Point(120, 400), 50, "Circle");
      window1.draw(canvas, new Color(139,69,16), true);
      new Text(window1.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Circle window1inner = new Circle(new Point(120, 400), 45, "Circle");
      window1inner.draw(canvas, new Color(200,255,255), true);
      new Text(window1inner.toString(), 600, textVerticalOffset+=20, canvas);
            pause(300);

      Circle window2 = new Circle(new Point(120, 525), 50, "Circle");
      window2.draw(canvas, new Color(139,69,16), true);
      new Text(window2.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Circle window2inner = new Circle(new Point(120, 525), 45, "Circle");
      window2inner.draw(canvas, new Color(200,255,255), true);
      new Text(window2inner.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);



      // fallen star

      Square houseBody = new Square(200,170,200,"Square");
      houseBody.draw(canvas, new Color( 70,130,180), true);
      new Text(houseBody.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square chimney = new Square(390, 55,40,"Square");
      chimney.draw(canvas, new Color(139,69,19), true);
      new Text(chimney.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Triangle roofLeft = new Triangle(new Point(200,170), new Point(280, 170), new Point(280,90), "Triangle");
      roofLeft.draw(canvas, new Color(170,170,170), true);  
      new Text(roofLeft.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square roofBodyLeft = new Square(280,90, 80,"Square");
      roofBodyLeft.draw(canvas, new Color(170,170,170), true);
      new Text(roofBodyLeft.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square roofBodyRight = new Square(360,90, 80,"Square");
      roofBodyRight.draw(canvas, new Color(170,170,170), true);  
      new Text(roofBodyRight.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Triangle side1 = new Triangle(new Point(480, 170), new Point(400, 170), new Point(440, 90),"Triangle");
      side1.draw(canvas, new Color( 135,206,250), true);  
      new Text(side1.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Triangle side2 = new Triangle(new Point(400,170), new Point(480,170), new Point(480, 340),"Triangle");
      side2.draw(canvas, new Color( 135,206,250), true);  
      new Text(side2.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Triangle side3 = new Triangle(new Point(400,170), new Point(400,370), new Point(480, 340),"Triangle");
      side3.draw(canvas, new Color( 135,206,250), true); 
      new Text(side3.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square fallenWindow1 = new Square(230, 210, 55, "Square");
      fallenWindow1.draw(canvas,new Color(230,255,255), true);
      new Text(fallenWindow1.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

      Square fallenWindow2 = new Square(320, 210, 55, "Square");
      fallenWindow2.draw(canvas,new Color(230,255,255), true);
      new Text(fallenWindow2.toString(), 600, textVerticalOffset+=20, canvas);
      pause(300);

    }
  }
}

