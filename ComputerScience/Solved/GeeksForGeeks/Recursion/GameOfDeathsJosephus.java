//https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] arr = br.readLine().split(" ");
		    int n = Integer.parseInt(arr[0]);
		    int k = Integer.parseInt(arr[1]);
		    System.out.println(gameOfDeaths(n,k));
		}
	}
	
	public static int gameOfDeaths(int n,int k){
	    if(n==1){
	        return n;
	    }
	    else{
	      return (gameOfDeaths(n-1,k)+k-1) % n +1;  
	    }
	}
}


// Iterative solution for Josephus Problem 
class Test 
{ 

	// Method for finding the winning child. 
	private int josephus(int n, int k) 
	{ 
		int sum = 0; 

		// For finding out the removed 
		// chairs in each iteration 
		for(int i = 2; i <= n; i++) 
		{ 
			sum = (sum + k) % i; 
		} 

		return sum+1; 
	} 

	// Driver Program to test above method 
	public static void main(String[] args) 
	{ 
		int n = 14; 
		int k = 2; 
		Test obj = new Test(); 
		System.out.println(obj.josephus(n, k)); 
	} 

	static int josephus(int n, int k)
{
if (n == 1)
    return 1;
else
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */
    return (josephus(n - 1, k) + k-1) % n + 1;
}
} 

// This code is contributed by Kumar Saras 
