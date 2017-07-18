/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #1
	September 23, 2005
	I certify that this assignment is entirely my own work. 
*/


import TerminalIO.KeyboardReader;

public class mystery {

	public static void main(String args[]) {
		
		int[] list = {0,-5,8,16,23};
		System.out.println(mystery2(list,0));
		
	}
	
public static int mystery2(int [] nums, int index) {
	
	if (nums.length == index + 1)
		return 0;
	else
		return nums[index] + mystery2(nums,index+1);
}

}
                    