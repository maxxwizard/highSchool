import java.util.*;
import java.io.*;

public class ppn
{ 
  public static void main(String [ ] args)
  {
    String input = "";
    
    //read in an equation
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Type in your equation: ");
      input = reader.readLine();
    }
    catch (IOException e)
    {
      System.err.println("Error: " + e);
    }
    
    char[] array = input.toCharArray();
    Stack stack = new Stack();
    String equation = "";
    for (int i = 0; i < array.length; i++)
    {
      //if char is a symbol
      if (isSymbol(array[i]))
      {
        
        //if stack is empty, add symbol to stack
        if (stack.isEmpty())
          stack.push(convert(array[i]));
          
        //else if symbol is closed paranthesis
        else if (convert(array[i]).intValue() == 5)
          //pop stack until open parathesis
          while (!stack.isEmpty() && ((Integer)(stack.peek())).intValue() != 0)
            equation += decode((Integer)(stack.pop()));
        
        //if symbol is same priority or higher, add to stack
        else if (priority(convert(array[i]),(Integer)(stack.peek())) == 0 || priority(convert(array[i]),(Integer)(stack.peek())) == 1)
          stack.push(convert(array[i]));
        
        //else if symbol is less priority  
        else
        {
          //pop the stack into equation
          while (!stack.isEmpty())
            equation += decode((Integer)(stack.pop()));
          //add symbol to stack
          stack.push(convert(array[i]));
        }

      }//end symbol if
      
      //if char is not a symbol
      else
        //add number or variable to equation
        equation += String.valueOf(array[i]);
    }
    
    //pop whole stack
    while (!stack.isEmpty())
      equation += decode((Integer)(stack.pop()));
    
    System.out.println("Your PPN equation is: " + equation);
  }

  public static boolean isSymbol(char c)
  {
    if (c == '(' ||
        c == '+' ||
        c == '-' ||
        c == '*' ||
        c == '/' ||
        c == ')' )
      return true;
    else
      return false;
  }
  public static Integer convert(char c)
  {
    Integer temp = new Integer(-1);
    if (c == '(')
      temp = new Integer(0);
    if (c == '+')
      temp = new Integer(1);
    if (c == '-')
      temp = new Integer(2);
    if (c == '*')
      temp = new Integer(3);
    if (c == '/')
      temp = new Integer(4);
    if (c == ')')
      temp = new Integer(5);
    return temp;
  }
  
  public static String decode(Integer c)
  {
    String temp = "";
    if (c.intValue() == 1)
      temp = "+";
    if (c.intValue() == 2)
      temp = "-";
    if (c.intValue() == 3)
      temp = "*";
    if (c.intValue() == 4)
      temp = "/";
    return temp;
  }
  
  //returns -1 if c is less than d
  //returns 0 if equal
  //returns 1 if c is greater than d
  public static int priority(Integer c, Integer d)
  {
    if (c.compareTo(d) == 0)
      return 0;
    else if (c.intValue() == 1 && d.intValue() == 2 || c.intValue() == 2 && d.intValue() == 1)
      return 0;
    else if (c.intValue() == 3 && d.intValue() == 4 || c.intValue() == 4 && d.intValue() == 3)
      return 0;
    else if (c.intValue() > d.intValue())
      return 1;
    else if (c.intValue() < d.intValue())
      return -1;
    
    return -2;
  }
}