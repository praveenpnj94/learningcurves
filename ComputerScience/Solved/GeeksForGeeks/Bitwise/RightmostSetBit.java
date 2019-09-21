//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    if(n==0){
		        System.out.println(0);
		    }
		    else{
                System.out.println((int)((Math.log10(n & -n)) / Math.log10(2)) + 1);		        
		    }
		}
	}
	
	public static int PositionRightmostSetbit(int n) 
    { 
        // Position variable initialize 
        // with 1 m variable is used to 
        // check the set bit 
        int position = 1; 
        int m = 1; 
  
        while ((n & m) == 0) { 
  
            // left shift 
            m = m << 1; 
            position++; 
        } 
        return position; 
    }
}