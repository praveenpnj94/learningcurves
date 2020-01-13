//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once

// Java code to segregate 0 and 1 
import java.util.*; 

class GFG{ 
/** 
Method for segregation 0 and 1 given input array 
*/
static void segregate0and1(int arr[]) { 
		int type0 = 0; 
		int type1 = arr.length - 1; 
		
		while (type0 < type1) { 
			if (arr[type0] == 1) { 
				// swap 
				arr[type1] = arr[type1]+ arr[type0]; 
				arr[type0] = arr[type1]-arr[type0]; 
				arr[type1] = arr[type1]-arr[type0]; 
				type1--; 
			} else { 
				type0++; 
			} 
		} 

	} 
	
// Driver program 
public static void main(String[] args) {	 
		
		int[] array = {0, 1, 0, 1, 1, 1}; 
		
		segregate0and1(array); 
		
		for(int a : array){ 
			System.out.print(a+" "); 
		} 
	} 
} 
