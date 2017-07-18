public class CircleDriver {

	public static void main(String args[]) {
		
			Circle[] circle = new Circle[5];
			
			for (int i = 0; i < circle.length; i++) {
				circle[i] = new Circle(i+1);
				}
				
			circleSort(circle);
				
			for (int i = 0; i < circle.length; i++) {
				System.out.println(circle[i]);
				}
				
		}//end main program code
	
}//end public class CircleDriver