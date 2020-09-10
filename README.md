#Short Response
1. All of the concrete classes inherited from the Shape class, and defined
their draw methods according to the specific shape. 
The square class was implemented by creating a FramedRect and FilledRect 
objcect, respectively, and then depeding on the argument, a square that was
filled in with solid color was created, or a square created with and empty
frame was made. The Circle class created a FilledOval and FramedOval object 
and based on the argument for fill, either a solid filled circle was made
or a framed circle was made. The Triangle class was a little more unique 
in sense that there was no Object to create to autogen a frame from the 
shape of a triangle. So three lines were made from the Class Line8B 
and Points were created conecting the lines and making a triangle. The
fill status was also a factor depding on the argument.

2. Screensaver.java was implemented by creating an Arraylist of Shape 
objects. Each element in the list was a different alternating shape 
between Circle, Square and Triangle. The list was retrieved from 
method call and each element was iterated across and using 
polymorphism, a downcast was done on the shape in order to call
its method in the program. Each method was called in the Shape and
also the unique fancy shape methods. The final product was displayed
on the screen and and kept in an infinite loop.

3. recursion works by basically recalling the same method within 
itslef using a paramter like "n" to decrement on each subsequent 
call to the method. A base case is the final case neded where the
parameter equals the base case param, and the method stops calling
on itself. This recursion is useful in situations where a method 
needed to be called over and over in the same way to produce a 
result with narrowing ouptut. 

4. Polymorphism is the act of using other types of class methods
and memebers while being a parent to that class or a relative to
the class. Polymorhpism can be very useful given the correct 
circumstances. When you want to create a tree like design of 
some type of object with different characteristsics throughout
but also sharing similarites, then it makes sense to limit ecxess
code and allow for the back and forth that polymorphism allows.

5. Polymorphism was used most notably during the execution of
methods within the Shapes contained in the Arraylist. These 
methods wouldnt have been able to be called without the ability
to downcast Shape into a spcefic Shape, like a circle or square etc. 
Otherwise we would have had to make an arraylist for each type of 
Shape! And its alot more code involved with oppurtunity to have errors. 

6. The most difficult bugs and errors I came across were during the 
implementation of the recursive methods. Finding the correct logic
and fucntioning algorithims can be very challenging, and that's 
often where the real "heavy duty" work comes in with programming. 
These problems were solved with time, and persistance, and constantly
testing against the code, and debugging as appropriate. 
