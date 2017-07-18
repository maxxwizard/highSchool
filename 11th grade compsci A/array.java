import java.util.Random;

public class array { 

public static void main(String args[]) {

	int[] list = new int[10];
	
	System.out.println("Array of 10 random numbers:");
	loadArray(list);
	writeArray(list);
	/*
	System.out.println("Max of list: " + getMax(list));
	System.out.println("Sum of list: " + getSum(list));
	System.out.println("Average of list: " + getAverage(list));
	System.out.println("Array search for 10: " + arraySearch(list,10));
	System.out.println("Array search for 15: " + arraySearch(list,15));
	System.out.println("Array search for 20: " + arraySearch(list,20));
	*/
	System.out.println("Array after bubble sorting:");
	bubbleSort(list);
	writeArray(list);

}//end main program

public static void loadArray(int[] a) {
	Random gen = new Random();
	for (int j = 0; j < a.length; j++)
		a[j] = gen.nextInt(100);
}

public static void writeArray(int[] a) {
	for (int i = 0; i < a.length; i++)
		System.out.println(a[i]);
}

public static int getMax(int[] a) {
	int max = a[0];

	for (int i = 1; i < a.length; i++) {
		if (a[i] > max)
				max = a[i];
	}

	return max;
}

public static int getSum(int[] a) {
	int sum = a[0];

	for (int i = 1; i < a.length - 1; i++)
		sum += a[i];

	return sum;
}

public static int getAverage(int[] a) {
	int average = getSum(a) / a.length;
	
	return average;
}

public static int arraySearch(int[] a, int val) {
	int pos = -1;
	
	for (int i = 0; i < a.length; i++) {
		if (a[i] == val)
			pos = i;
	}
	
	return pos;
}

public static void bubbleSort(int[] a) {

	int x;

	for (int i = 0; i < a.length - 1; i++) {
		for (int j = 0; j < a.length - 1; j++) {
			if (a[j] > a[j+1]) {
				x = a[j];
				a[j] = a[j+1];
				a[j+1] = x;
				}
		}
	}
	
}

}//end public class array