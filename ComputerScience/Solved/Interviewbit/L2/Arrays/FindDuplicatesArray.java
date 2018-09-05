//https://www.geeksforgeeks.org/find-duplicates-constant-array-elements-0-n-1-o1-space/
//https://www.interviewbit.com/problems/find-duplicate-in-array/


// Java program to find a duplicate
// element in an array with values in
// range from 0 to n-1.
import java.io.*;
import java.util.*;

public class GFG {
	
	// function to find one duplicate
	static int findduplicate(int []arr, int n)
	{
		
		// return -1 because in these cases 
		// there can not be any repeated element
		if (n <= 1)
			return -1;
	
		// initialize fast and slow
		int slow = arr[0];
		int fast = arr[arr[0]];
	
		// loop to enter in the cycle
		while (fast != slow) 
		{
	
			// move one step for slow
			slow = arr[slow];
	
			// move two step for fast
			fast = arr[arr[fast]];
		}
	
		// loop to find entry
		// point of the cycle
		fast = 0;
		while (slow != fast)
		{
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int []arr = {1, 2, 3, 4, 5, 6, 3};
		int n = arr.length;
		System.out.print(findduplicate(arr, n));
	}
}

// This code is contributed by
// Manish Shaw (manishshaw1)
