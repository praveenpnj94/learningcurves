//https://www.youtube.com/watch?v=jH_5ypQggWg
//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(minJumps(a,n));
        }
    }
    public static int minJumps(int[] a , int n){
        if(a[0]==0){
            return -1;
        }
        int[] jump = new int[n];
        Arrays.fill(jump,Integer.MAX_VALUE);
        jump[0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(i<=j+a[j]){
                    jump[i]=Math.min(jump[i],1+jump[j]);
                }
            }
        }
        return jump[n-1]==Integer.MAX_VALUE?-1:jump[n-1];
    }
}


// Java program to count Minimum number 
// of jumps to reach end 
//Linear SOlution
//https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
class Test 
{ 
	static int minJumps(int arr[]) 
	{ 
		if (arr.length <= 1) 
			return 0; 

		// Return -1 if not possible to jump 
		if (arr[0] == 0) 
			return -1; 

		// initialization 
		int maxReach = arr[0]; 
		int step = arr[0]; 
		int jump = 1; 


		// Start traversing array 
		for (int i = 1; i < arr.length; i++) 
		{ 
			// Check if we have reached the end of the array 
			if (i == arr.length - 1) 
				return jump; 

			// updating maxReach 
			maxReach = Math.max(maxReach, i+arr[i]); 

			// we use a step to get to the current index 
			step--; 

			// If no further steps left 
			if (step == 0) 
			{ 
				// we must have used a jump 
				jump++; 
				
				//Check if the current index/position or lesser index 
				// is the maximum reach point from the previous indexes 
				if(i>=maxReach) 
				return -1; 

				// re-initialize the steps to the amount 
				// of steps to reach maxReach from position i. 
				step = maxReach - i; 
			} 
		} 

		return -1; 
	} 

	// Driver method to test the above function 
	public static void main(String[] args) 
	{ 
		int arr[] = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; 

		// calling minJumps method 
		System.out.println(minJumps(arr)); 
	} 
} 
