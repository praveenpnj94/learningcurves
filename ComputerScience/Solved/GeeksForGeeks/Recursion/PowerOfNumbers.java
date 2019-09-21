//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//https://www.geeksforgeeks.org/modular-exponentiation-recursive/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(power(br.readLine()));
		}
	}
	public static Long power(String s){
	    StringBuilder str = new StringBuilder(s); 
	    String r = str.reverse().toString();
	    if(Long.parseLong(s)==0){
	        return 1L;
	    }
	    return pow(Long.parseLong(s),Long.parseLong(r))%1000000007;
	}
	public static long pow(long x, long y){
	    
	    if (y == 0) 
            return 1; 
        long temp= pow(x, y / 2);
        if (y % 2 == 0) 
            return (temp%1000000007*temp%1000000007); 
        else
            return (x * temp%1000000007 * temp%1000000007); 
	}
}