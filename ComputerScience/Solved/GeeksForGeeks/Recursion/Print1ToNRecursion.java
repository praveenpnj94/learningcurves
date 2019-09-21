//https://www.geeksforgeeks.org/how-will-you-print-numbers-from-1-to-200-without-using-loop/

import java.io.*; 
import java.util.*; 
import java.text.*; 
import java.math.*; 
import java.util.regex.*; 

class GFG 
{ 
	// Prints numbers from 1 to n 
	static void printNos(int n) 
	{ 
		if(n > 0) 
		{ 
			printNos(n - 1); 
			System.out.print(n + " "); 
		} 
		return; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		printNos(100); 
	} 
} 

// This code is contributed by Manish_100 
