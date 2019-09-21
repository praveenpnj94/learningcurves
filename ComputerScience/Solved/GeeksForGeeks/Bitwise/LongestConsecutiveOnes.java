//https://www.geeksforgeeks.org/length-longest-consecutive-1s-binary-representation/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(maxConsecutiveOnes(Integer.parseInt(br.readLine())));   
		}
	}
    private static int maxConsecutiveOnes(int x) 
    { 
        // Initialize result 
        int count = 0; 
  
        // Count the number of iterations to 
        // reach x = 0. 
        while (x!=0) 
        { 
            // This operation reduces length 
            // of every sequence of 1s by one. 
            x = (x & (x << 1)); 
  
            count++; 
        } 
  
        return count; 
    }
}