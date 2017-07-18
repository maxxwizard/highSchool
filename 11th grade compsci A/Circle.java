public class Circle implements Comparable
{
  private int radius;
  
  public Circle()
  {
    radius = 1;
  }
  
  public Circle(int rad)
  {
    radius = rad;
  }
  
  public double getArea()
  {
    return Math.PI * radius * radius;
  }
  
  public double getCircumference()
  {
    return 2*Math.PI * radius;
  }
  
  public void setRadius(int rad)
  {
    if (rad > 0) 
      radius = rad;
    else
      radius = 1;
  }
  
   public int getRadius()
  {
    return radius;
  }
  
  public boolean equals(Object other)
  {
  	return (radius == ((Circle)other).radius);
  }

  public int compareTo(Object other)
  {
    int diff = radius - ((Circle)other).getRadius();
    return diff;
  }
  
  public String toString()
  {
    return "Circle of radius " + radius + ".";
  }
  
  public static void circleSort(Circle[] a) {

	for (int i = 0; i < a.length - 1; i++) {
		for (int j = 0; j < a.length - 1; j++) {
			if (a[j].radius < a[j+1].radius) {
				Circle x = a[j];
				a[j] = a[j+1];
				a[j+1] = x;
			}
		}
	}
	
}

}//end public class Circle
