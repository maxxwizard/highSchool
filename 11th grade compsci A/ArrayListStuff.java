import java.util.ArrayList;

public class CircleDriver
{
  public static void main(String[] args)
  {
    ArrayList list = new ArrayList();
    String takenOut;
    
    //Enter objects into ArrayList
    list.add(new Integer(8));		//Must be objects; use wrappers
    list.add(new Integer(5));		
    list.add(new Double(3.14));
    list.add("hi");					//Strings are objects; no wrapper needed
    list.add(new Circle(7));		//Circle objects
    
    System.out.println(list.get(1));	//Second element
    //5
    System.out.println(list.get(3));	//Fourth element uses Circle's toString
    //hi
    
    System.out.println(list);		//Array Lists have their own toString
    //[8, 5, 3.14, hi, Circle of radius 7. (kent says 7)]
    System.out.println("list.size() = "+list.size());	 //Print out size
    //list.size() = 5
    list.remove(0);					//Can stand alone 
    takenOut = (String)list.remove(2);		//Removes the third element; returns as object
    System.out.println(list);
    //[5, 3.14, Circle of radius 7. (kent says 7)]
    System.out.println("Taken out: " + takenOut);
    //Taken out: hi
    
    list.set(1,new Circle(3));		//Change the second element to a circle object
    System.out.println(list);
    //[5, Circle of radius 3., Circle of radius 7.]
    list.add(new Character('x'));
    list.add(new Double(4.25));
    System.out.println(list);
    //[5, Circle of radius 3., Circle of radius 7., x, 4.25]
    
   	list.add(4,"Square");			//Insert and shift add.
	System.out.println(list);
	//[5, Circle of radius 3., Circle of radius 7., x, Square, 4.25]
	list.add(2,new Double(2.71));
	System.out.println(list);
	//[5, Circle of radius 3., 2.71, Circle of radius 7., x, Square, 4.25]
    }
}