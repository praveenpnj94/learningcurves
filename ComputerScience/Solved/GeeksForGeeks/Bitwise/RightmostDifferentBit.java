//https://www.geeksforgeeks.org/position-rightmost-different-bit/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] lines = br.readLine().split(" ");
		    int a = Integer.parseInt(lines[0]);
		    int b = Integer.parseInt(lines[1]);
		    System.out.println(rightmostDifferentBit(a,b));
		}
	}
	
	public static int rightmostDifferentBit(int a, int b){
	    if(a==b){
	        return 0;
	    }
	    return getRightMostSetBit(a^b); 
	}
	
    public static int getRightMostSetBit(int n)  
    { 
        return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1; 
    }
}